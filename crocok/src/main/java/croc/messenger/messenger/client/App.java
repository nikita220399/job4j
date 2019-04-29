package croc.messenger.messenger.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import croc.messenger.messenger.common.Message;
import croc.messenger.messenger.common.User;

public class App extends Application {

	private final Client client;
	private final User user;

	private long t = 0L;
	private Thread updateThread;

	// ui elements
	private VBox chatBox;
	private ScrollPane scroll;
	private TextField messageField;

	public static void main(String[] args) {
		launch(args);
	}

	public App() {
		this.client = new Client("localhost", 55);
		this.user = new User(Names.randomName());
	}

	@Override
	public void start(Stage primaryStage) {
		int maxWidth = 1000;
		int maxHeight = 1000;

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10));


		Label chatName = new Label("Chat with notebook:");
		grid.add(chatName, 0, 0, 2, 1);

		chatBox = new VBox();
		chatBox.setFillWidth(false);

		scroll = new ScrollPane(chatBox);
		scroll.setBackground(new Background(
				new BackgroundFill(Color.TRANSPARENT, null, null)));
		scroll.setPrefWidth(maxWidth);
		scroll.setPrefHeight(maxHeight);
		grid.add(scroll, 0, 1, 2, 1);
		chatBox.heightProperty().addListener(observable -> scroll.setVvalue(1.0));

		// sample message
		messageField = new TextField();
		messageField.setPrefWidth(maxWidth);
		grid.add(messageField, 0, 2);

		Button send = new Button("Say!");
		send.setMinWidth(70);
		send.setOnAction(event -> {
			String text = messageField.getText();
			if (text.isEmpty())
				return;

			Message message = new Message(user, text);
			sendMessage(message);
		});
		messageField.setOnKeyPressed(event -> {
			if (event.getCode().equals(KeyCode.ENTER))
				send.fire();
		});
		grid.add(send, 1, 2);

		Scene scene = new Scene(grid, 400, 500);
		primaryStage.setTitle("Messenger");
		primaryStage.setScene(scene);
		primaryStage.show();

		// load messages from server
		updateThread = new Thread(new UpdateChatTask());
		updateThread.start();
	}

	@Override
	public void stop() {
		updateThread.interrupt();
	}

	private VBox createMessageBox(Message message) {
		int messageWidth = 300;

		Color color = message.getUser().equals(user)
				? Color.BISQUE
				: Color.WHITE;

		VBox messageBox = new VBox();
		messageBox.setPadding(new Insets(3, 10, 3, 10));
		messageBox.setFillWidth(false);
		messageBox.setPrefWidth(messageWidth);
		messageBox.setBackground(new Background(new BackgroundFill(
				color,
				new CornerRadii(8),
				Insets.EMPTY)));
		// user
		Label messageUser = new Label();
		messageUser.setText(message.getUser().getName());
		messageUser.setFont(Font.font(
				"Arial",
				FontWeight.BOLD,
				Font.getDefault().getSize()));
		messageUser.setPadding(new Insets(0, 0, 3, 0));
		messageBox.getChildren().add(messageUser);
		// text
		Text messageText = new Text();
		messageText.setText(message.getText());
		messageText.setWrappingWidth(messageWidth);
		messageBox.getChildren().add(messageText);
		// time
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Label messageTime = new Label();
		messageTime.setText(sdf.format(message.getTime()));
		messageTime.setTextFill(Color.DARKSEAGREEN);
		messageTime.setPadding(new Insets(3, 0, 0, 0));
		messageBox.getChildren().add(messageTime);

		VBox container = new VBox();
		container.setPadding(new Insets(3));
		container.getChildren().add(messageBox);
		container.setAlignment(Pos.TOP_RIGHT);
		return container;
	}

	private synchronized void sendMessage(Message message) {
		if (message == null)
			return;
		try {
			client.sendMessage(message);
			messageField.setText("");
			messageField.setStyle("-fx-text-fill: black;");
		} catch (IOException e) {
			messageField.setStyle("-fx-text-fill: red;");
			e.printStackTrace();
		}
	}

	private synchronized void updateChat() {
		List<Message> messages;
		try {
			messages = client.getMessages(new Date(t));
		} catch (IOException e) {
			// do nothing
			return;
		}
		for (Message message : messages) {
			VBox messageBox = createMessageBox(message);
			Platform.runLater(() -> {
				chatBox.getChildren().add(messageBox);
			});
			t = Math.max(t, message.getTime().getTime() + 1);
		}
	}

	private class UpdateChatTask implements Runnable {

		@Override
		public void run() {
			while (!Thread.interrupted()) {
				updateChat();
				try {
					Thread.sleep(1_000L);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
}
