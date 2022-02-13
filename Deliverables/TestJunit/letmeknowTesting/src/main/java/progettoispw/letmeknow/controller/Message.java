package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.ChatBean;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.controller.chat.Messages;

public class Message{
    public enum ScreenSize{
        LAPTOP,SMARTPHONE
    }
    private ScreenSize size;
    public void newMsg(String from,String to , String text){
        Messages chat=new Messages(from);
        chat.newMessage(text,to);
    }
    public String getLmsg(String userid1,String userid2){
        ChatBean chatBean;
        String [] inner;
        ControllerClass.controllerUser(userid1);
        ControllerClass.getChat().setTouched(userid2);
        chatBean=new ChatBean();
        inner=chatBean.getMSG();
        return inner[inner.length-1];
    }
    public String[] getListLmsgs(String userid1){
        ISCBean listUsersBean;

        ControllerClass.controllerUser(userid1);
        //
        if(size==ScreenSize.LAPTOP) listUsersBean=new ISCBean();
        //it could be also equals to one it depends if the new user could send and recive message not by test
        else listUsersBean=new ISCBean(1);
        return listUsersBean.exitUid()[0];
    }

    public void setSize(ScreenSize size) {
        this.size = size;
    }
}
