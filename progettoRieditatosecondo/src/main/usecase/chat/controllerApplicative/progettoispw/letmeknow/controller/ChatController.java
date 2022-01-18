package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ChatController {
    private Messages actChat;
    private ArrayList<Message> chat;
    private ArrayList<Message>lastChat;
    private ArrayList<Message> newChat;
    private String with;
    public ChatController(){
        actChat= ControllerClass.getChat();
        with=actChat.getTouched();
    }
    public void  newMSG(String text){
        actChat.newMessage(text,with);
    }
    public String getUID(){
        return actChat.getUserid();
    }
    public List<Message> getChat() {
        chat=actChat.chat(with);
        if(lastChat!=null){
            newChat=new ArrayList<>();
            for(int i= lastChat.size();i< chat.size();i++){
                newChat.add(chat.get(i));
            }
            lastChat=chat;
        }
        else {
            lastChat=chat;
            newChat=chat;
        }
        return newChat;
    }
    public String getWith() {
        return with;
    }
}
