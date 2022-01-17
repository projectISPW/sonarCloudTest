package progettoispw.letmeknow.bean;


import progettoispw.letmeknow.controller.ChatController;
import progettoispw.letmeknow.controller.SignupController;
import progettoispw.letmeknow.controller.chat.Message;

import java.util.Vector;

import static java.lang.Thread.sleep;

public class ChatBean{
    private ChatController controller;
    private Vector<Message> chat;
    private Integer index;
    private String with;
    public ChatBean() {
        controller=new ChatController();
        with= controller.getWith() ;
        index=0;
    }
    public String getWith(){
        return with;
    }
    public void getChat(){
        chat=controller.getChat();
    }
    public String[]getMSG(){
        String [] returnStr =new String[chat.size()*2];
        int indice=0;
       for(Message msg:chat){
           returnStr[indice++]= msg.getText();
            if(msg.getReciver().equals(with))returnStr[indice++]="i am the sender";
            else returnStr[indice++]="i am the reciver";
       }
        return returnStr;
    }
    public String getUid(){
        return controller.getUID();
    }
    public void newMsg(String input){
        controller.newMSG(input);
    }
}
