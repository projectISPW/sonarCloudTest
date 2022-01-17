package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;

import java.util.Vector;

public class ChatController {
    private ControllerClass factory;
    private Messages actChat;
    private Vector<Message> chat;
    private Vector<Message>lastChat;
    private Vector<Message> newChat;
    private String with;
    public ChatController(){
        factory =new ControllerClass();
        actChat= factory.getChat();
        with=actChat.getTouched();
    }
    public void  newMSG(String text){
        actChat.newMessage(text,with);
    }
    public String getUID(){
        return actChat.getUserid();
    }
    public Vector<Message> getChat() {
        chat=actChat.chat(with);
        if(lastChat!=null){
            newChat=new Vector<>();
            for(int i= lastChat.size();i< chat.size();i++){
                newChat.add(chat.get(i));
            }
            lastChat=chat;
        }
        else {
            lastChat=chat;
            newChat=chat;
        }
        //for(Message msg :newChat)msg.getStatus();
        return newChat;
    }

    public String getWith() {
        return with;
    }
}
