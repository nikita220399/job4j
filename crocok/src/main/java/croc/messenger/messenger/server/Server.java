package croc.messenger.messenger.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import croc.messenger.messenger.common.Message;
import croc.messenger.messenger.common.User;

public class Server {

	private final int port;
	private ExecutorService pool;
	private ServerSocket server;

	private final MessageRepository messageRepository = new MessageRepository();
	private final Map<User, Bot> bots = new HashMap<>();

	public Server() {
		this(55);
	}

	public Server(int port) {
		this.port = port;

		registerBots();
	}

	private void registerBots() {
		Bot daisyBot = new DaisyBot();
		bots.put(daisyBot.getUser(), daisyBot);
	}

	public void start() throws IOException {
		pool = Executors.newCachedThreadPool();
		server = new ServerSocket(port);
		for (int i = 0; i < 4; i++) {
			pool.submit(()
					-> handleRequests(server));
		}
	}

	public void stop() {
		pool.shutdownNow();
		try {
			server.close();
		} catch (IOException ignore) {
		}
	}

	private void handleRequests(ServerSocket server) {
		Objects.requireNonNull(server);

		while (true) {
			try (Socket socket = server.accept()) {
				InputStream in = socket.getInputStream();

				Scanner s = new Scanner(in);
				String commandStr = s.nextLine();
				int command = Integer.parseInt(commandStr);
				switch (command) {
					case 0: // send message
						String username = s.nextLine();
						String text = s.nextLine();
						User user = new User(username);
						Message message = new Message(user, text);

						messageRepository.addMessage(message);
						User mention = message.getMention();
						if (mention != null) {
							Bot bot = bots.get(mention);
							if (bot != null) {
								pool.submit(()
										-> bot.onMessage(message, messageRepository));
							}
						}
						break;
					case 1:
						String timeStr = s.nextLine();
						Date time = new Date(Long.parseLong(timeStr));
						List<Message> result = messageRepository.findMessagesAfter(time);

						// return result to a client
						try (Writer w = new OutputStreamWriter(socket.getOutputStream())) {
							w.write(Integer.toString(result.size()));
							w.write("\n");
							for (Message msg : result) {
								w.write(msg.getUser().getName());
								w.write("\n");
								w.write(Long.toString(msg.getTime().getTime()));
								w.write("\n");
								w.write(msg.getTextLine());
								w.write("\n");
							}
						}
						break;
				}
			} catch (Exception e) {
				// command error
				// do nothing and continue to a next connection
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start();

		Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
	}
}
