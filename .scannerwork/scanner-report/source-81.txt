package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.controller.chat.Messages;

public class Message{
    private enum ScreenSize{
        LAPTOP,SMARTPHONE
    }
    private static ScreenSize size;
    public void newMsg(String from,String to , String text){
        Messages chat=new Messages(from);
        chat.newMessage(text,to);
    }
    public String getRecived(String userid1,String userid2){
        size=ScreenSize.LAPTOP;
        ISCBean bean;
        ControllerClass.controllerUser(userid1);
        ControllerClass.getChat().setTouched(userid2);
        if(size==ScreenSize.LAPTOP) bean=new ISCBean();
        //it could be also equals to one it depends if the new user could send and recive message not by test
        else bean=new ISCBean(1);
        return bean.exitUid()[0][0];
    }
}
