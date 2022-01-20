package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.chat.Message;

public class lastMessage {
    private String userid;
    private String lastmsg;
    private WordCheck check;
    private int lenMax=40;
    public lastMessage(String elem, Message message){
        userid=elem;
        check=new WordCheck();
        lastmsg=message.getText();

    }
    public String getUserid() {
        return userid;
    }
    public String getLastmsg() {
        lastmsg=check.checkLen(lastmsg,lenMax);
        return lastmsg;
    }
    public void getStatus(){
        System.out.println("last text in chat with .:  " +userid+ "is .:  "+lastmsg);
    }
}
