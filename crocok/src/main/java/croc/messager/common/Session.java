package croc.messager.common;

import croc.messager.server.Server;

public class Session {
    private Server server;

//    public void sendMessage(String chatName, Message message) {
//        Chat chat = null;
//        for (Chat serverChat : server.getChats()) {
//            if (serverChat.getName().equals(chatName)) {
//                chat = serverChat;
//                break;
//            }
//        }
//        if (chat != null) {
//            chat.sendMessage(message);
//        }
//    }

    public void receiveMessage(Message message) {

    }
}
