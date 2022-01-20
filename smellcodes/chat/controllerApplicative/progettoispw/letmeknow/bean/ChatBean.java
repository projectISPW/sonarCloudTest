//took out unused libraries

package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ChatController;
import progettoispw.letmeknow.controller.chat.Message;
import java.util.ArrayList;




public class ChatBean{
    private ChatController controller;
    private ArrayList<Message> chat;
    //private Integer index;
    private String with;
    public ChatBean() {
        controller=new ChatController();
        with= controller.getWith() ;
       // index=0; dice che non è mai usata, va tolta?
    }
    public String getWith(){
        return with;
    }
    public void getChat(){
        chat= (ArrayList<Message>) controller.getChat();
    }
    public String[]getMSG(){
        String [] returnStr =new String[chat.size()*2];
        int index=0;
       for(Message msg:chat){
           returnStr[index++]= msg.getText();
            if(msg.getReciver().equals(with))returnStr[index++]="i am the sender";
            else returnStr[index++]="i am the receiver";
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
