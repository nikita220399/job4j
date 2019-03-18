package croc.messager.common;

import java.util.Date;

public class Message {
    private final User author;
    private final String text;
    private final Date time;

    public Message(User author, String text) {
        this.author = author;
        this.text = text;
        this.time = new Date(); // now
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getTime() {
        return time;
    }
}
