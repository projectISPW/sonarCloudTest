package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.LastMessage;
import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;

import java.util.ArrayList;
import java.util.List;
public class ISCController {
    private Integer count;
    private Integer nVal;
    private Messages chat;
    private String find;
    public ISCController(Integer n){
        ControllerClass.controllerChat();
        ControllerClass.setSearch();
        chat= ControllerClass.getChat();
        nVal=n;
        count=0;
        find=null;
    }
    public ISCController(){
        ControllerClass.controllerChat();
        if(ControllerClass.getSearch()==null)ControllerClass.setSearch();
        chat= ControllerClass.getChat();
        nVal=0;
        count=0;
        find=null;
    }
    public String getUid(){
        return chat.getUserid();
    }
    public String check(Message msg){
        if(msg.getReciver().equals(getUid()))return msg.getSender();
        return msg.getReciver();
    }
    private List<LastMessage> getListV1( ){
        //lista utenti con ultimo messaggio per la interfaccia 2
        ArrayList <Message> lmsgs=(ArrayList<Message>) chat.getLast();
        if(lmsgs.isEmpty())return new ArrayList<>();
        LastMessage actual;
        ArrayList <LastMessage> formatted  = new ArrayList<>();
        for (Message msg:lmsgs) {
            actual = new LastMessage(check(msg),msg);
            formatted.add(actual);
        }
        return formatted;
    }
    private List<LastMessage> getListV2(String find){
        //ricerca messaggi sulla lista utenti 2
        List <Message>msgs= chat.getLocalSearch(find);
        if(msgs.isEmpty())return new ArrayList<>();
        ArrayList <LastMessage> formatted  = new ArrayList<>();
        LastMessage actual;
        for (Message msg : msgs) {
            actual = new LastMessage(msg.getSender()+"||"+msg.getReciver(), msg);
            formatted.add(actual);
        }
        return formatted;
    }
    private List<LastMessage>getListV3(){
        //lista utenti con ultimo messaggio per la interfaccia 1

        ArrayList <Message> lmsgs=(ArrayList<Message>) chat.getLast();
        if(lmsgs.isEmpty())return new ArrayList<>();
        LastMessage actual;
        Message msg;
        ArrayList<Message>inner=new ArrayList<>();

        int index=0;
        ArrayList <LastMessage> formatted  = new ArrayList<>();
        while(index<nVal){
            count = check(count, lmsgs);
            msg=lmsgs.get(count);
            if(inner.contains(msg))break;
            count++;
            actual = new LastMessage(check(msg),msg);
            formatted.add(actual);
            inner.add(msg);
            index++;
        }
        return formatted;
    }
    private List<LastMessage>getListV4(String find ){
        List <Message>msgs= chat.getLocalSearch(find);
        if(msgs.isEmpty())return new ArrayList<>();
        LastMessage actual;
        ArrayList <LastMessage> formatted  = new ArrayList<>();
        ArrayList<Message>inner=new ArrayList<>();
        int index=0;
        while(index++<nVal){
            count = check(count, (ArrayList<Message>) msgs);
            Message msg=msgs.get(count++);
            if(inner.contains(msg))break;
            actual = new LastMessage(msg.getSender()+"||"+msg.getReciver(), msg);
            formatted.add(actual);
            inner.add(msg);
        }

        return formatted;
    }
    public List<LastMessage> queryUsers(){

        if(find==null){
            if(nVal==0){
                return getListV1();
            }
            else{//list users in interf1
                return getListV3();
            }}else{
            return queryUsers(find);
        }
    }
    public List<LastMessage> queryUsers(String find){
        if(nVal==0){
            return getListV2(find);
        }
        else {//search activated in list users iterf1
            return getListV4(find);
        }
    }
    private Integer check(Integer count,ArrayList<Message> list) {
        if(count>=list.size()){
            count=0;
        }
        return count;
    }
    public void who(String usr){
        chat.setTouched(usr);
    }
    public void search(String input){
        count=0;
        find=input;
    }
    public void reset(){
        count=0;
        find=null;
    }
}
