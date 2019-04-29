package croc.messenger.messenger.common;

import java.util.Date;
import java.util.Objects;

public class Message implements Comparable<Message> {

	private final User user;
	private final User mention;
	private final String text;
	private final Date time;

	public Message(User user, String text) {
		this(user, text, new Date());
	}

	public Message(User user, String text, Date time) {
		Objects.requireNonNull(user);
		Objects.requireNonNull(time);

		this.user = user;
		if (text == null)
			text = "";
		text = restoreLineBreaks(text);
		int k = 0;
		for (; k < text.length(); k++) {
			if (text.charAt(k) == ' '
					|| text.charAt(k) == ','
					|| text.charAt(k) == '\r'
					|| text.charAt(k) == '\n')
				break;
		}
		if (k < text.length() - 1) {
			String str = text.substring(0, k).trim();
			if (str.startsWith("@")) {
				mention = new User(str.substring(1));
				text = text.substring(k + 1);
			} else {
				mention = null;
			}
		} else {
			mention = null;
		}
		this.text = text;
		this.time = time;
	}

	private static String removeLineBreaks(String text) {
		if (text == null)
			return text;
		return text.replaceAll("\n|\r\n|\r", "<br>");
	}

	private static String restoreLineBreaks(String text) {
		if (text == null)
			return text;
		return text.replaceAll("<br>", "\n");
	}

	public static String textWithMention(User mention, String text) {
		if (text == null)
			text = "";
		return mention != null
				? mention.toString() + " " + text
				: text;
	}

	public User getUser() {
		return user;
	}

	public User getMention() {
		return mention;
	}

	public String getText() {
		return textWithMention(mention, text);
	}

	public String getTextLine() {
		return removeLineBreaks(getText());
	}

	public Date getTime() {
		return time;
	}

	@Override
	public int compareTo(Message other) {
		return time.compareTo(other.time);
	}
}
