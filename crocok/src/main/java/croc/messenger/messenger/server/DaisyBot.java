package croc.messenger.messenger.server;

import croc.messenger.messenger.common.Message;
import croc.messenger.messenger.common.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DaisyBot implements Bot {

	private final User daisy = new User("Notebook");
	private final Random rnd = new Random(System.currentTimeMillis());
	private static int count = -1;
	private List<String> text = new ArrayList<>();

	@Override
	public User getUser() {
		return daisy;
	}

	@Override
	public void onMessage(Message message, MessageRepository messageRepository) {
		Tracker tracker = new Tracker();

		if (message.getTextLine().equals("@Notebook menu")) {
			text.removeAll(text);
			count = -1;
		}

		if (count > 5 || count < 0) {
			text.removeAll(text);
			text.add("Salaam alaikum \n" +
					"Select : \n" +
					"\n" +
					"0 : Add the new item. \n" +
					"1 : Show items. \n" +
					"2 : Edit the new item. \n" +
					"3 : Delete items. \n" +
					"4 : Find ID items. \n" +
					"5 : Find Name items.");
		}


		if (count == 0) {
			String[] str = message.getTextLine().split(";");;
			Item item = new Item(str[1], str[2]);
				tracker.add(item);
				text.removeAll(text);
				count = -1;
		}
		if (count == 2) {
			String[] str = message.getTextLine().split(";");
			boolean flag = tracker.replace(str[1], str[2]);
			if (flag == true) {
				text.removeAll(text);
				text.add("Edit successfully");
				count = -1;
			} else {
				text.removeAll(text);
				text.add("Not found ID. Enter again / Menu");
			}
		}
		if (count == 3) {
			String[] str = message.getTextLine().split(";");
			boolean flag = tracker.delete(str[1]);
			if (flag == true) {
				text.removeAll(text);
				text.add("Delete successfully");
				count = -1;
			} else {
				text.removeAll(text);
				text.add("Not found ID. Enter again / Menu");
			}
		}
		if (count == 4) {
			String[] str = message.getTextLine().split(";");
			Item k = tracker.findById(str[1]);
			if (k == null) {
				text.removeAll(text);
				text.add("Not found ID. Enter again / Menu");
			} else {
				text.removeAll(text);
				text.add(k.toString2());
			}
		}
		if (count == 5) {
			String[] str = message.getTextLine().split(";");
			Item[] i = tracker.findByName(str[1]);
			if (i.length != 0) {
				text.removeAll(text);
				int j = 1;
				for (Item item : i) {
					text.add(item.toString(j));
					j++;
				}
				count = -1;
			}
			else {
				text.removeAll(text);
				text.add("Enter Name again / Menu");
			}
		}

		if (message.getTextLine().equals("@Notebook 0")) {
			text.removeAll(text);
			text.add("Enter the title and description of the Item (split(;))");
			count = 0;
		}

		if (message.getTextLine().equals("@Notebook 1")) {
			text.removeAll(text);
			List<Item> list = tracker.findAll();
			if (list.size() == 0) {
				text.add("No Items in the notebook. Menu?");
			} else {
				int i = 1;
				for (Item item : list) {
					text.add(item.toString(i));
					i++;
				}
			}
			count = -1;
		}

		if (message.getTextLine().equals("@Notebook 2")) {
			text.removeAll(text);
			text.add("Enter ID and new description of the Item (split(;))");
			count = 2;
		}

		if (message.getTextLine().equals("@Notebook 3")) {
			text.removeAll(text);
			text.add("Enter ID of the Item");
			count = 3;
		}

		if (message.getTextLine().equals("@Notebook 4")) {
			text.removeAll(text);
			text.add("Enter ID of the Item");
			count = 4;
		}

		if (message.getTextLine().equals("@Notebook 5")) {
			text.removeAll(text);
			text.add("Enter Name of the Item");
			count = 5;
		}

		// imitate delay: do not reply instantly
		int delaySeconds = 1 + rnd.nextInt(3);
		try {
			Thread.sleep(delaySeconds * 1000);
		} catch (InterruptedException e) {
			return;
		}

		for (String s : text) {
			Message replyFromDaisy = new Message(
					daisy,
					Message.textWithMention(message.getUser(), s));
			messageRepository.addMessage(replyFromDaisy);
		}
	}
}
