package croc.messager.server;

import croc.messager.common.Chat;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Chat> chats = new ArrayList<>();

    public List<Chat> getChats() {
        return chats;
    }
}
