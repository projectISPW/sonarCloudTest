package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.lastMessage;
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
            if(ControllerClass.getSearch()==null)ControllerClass.controllerUsers();
            chat= ControllerClass.getChat();
            nVal=n;
            count=0;
            find=null;
        }
        public ISCController(){
             ControllerClass.controllerChat();
            if(ControllerClass.getSearch()==null)ControllerClass.controllerUsers();
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
        private List<lastMessage> getListV1( ){
            //lista utenti con ultimo messaggio per la interfaccia 2
            ArrayList <Message> lmsgs=(ArrayList<Message>) chat.getLast();
            lastMessage actual;
            ArrayList <lastMessage> formatted  = new ArrayList<>();
            for (Message msg:lmsgs) {
                actual = new lastMessage(check(msg),msg);
                actual.getStatus();
                formatted.add(actual);
            }
            return formatted;
        }
        private List<lastMessage> getListV2(String find){
        //ricerca messaggi sulla lista utenti 2
            ArrayList <Message>msgs=(ArrayList<Message>) chat.getLocalSearch(find);
            ArrayList <lastMessage> formatted  = new ArrayList<>();
            lastMessage actual;
            for (Message msg : msgs) {
                actual = new lastMessage(msg.getSender()+"||"+msg.getReciver(), msg);
                formatted.add(actual);
            }
            return formatted;
        }
        private List<lastMessage>getListV3(){
            //lista utenti con ultimo messaggio per la interfaccia 1
            ArrayList <Message> lmsgs=(ArrayList<Message>) chat.getLast();
            lastMessage actual;
            ArrayList<Message>inner=new ArrayList<>();
            int index=0;
            ArrayList <lastMessage> formatted  = new ArrayList<>();
            while(index<nVal){
                count = check(count, lmsgs);
                Message msg=lmsgs.get(count);
                if(inner.contains(msg))break;
                count++;
                actual = new lastMessage(check(msg),msg);
                formatted.add(actual);
                inner.add(msg);
                index++;
            }
            return formatted;
        }
        private List<lastMessage>getListV4(String find ){
            ArrayList <Message>msgs= chat.getLocalSearch(find);
            lastMessage actual;
            ArrayList <lastMessage> formatted  = new ArrayList<>();
            ArrayList<Message>inner=new ArrayList<>();
            int index=0;
            while(index++<nVal){
                count = check(count, msgs);
                Message msg=msgs.get(count++);
                if(inner.contains(msg))break;
                actual = new lastMessage(msg.getSender()+"||"+msg.getReciver(), msg);
                actual.getStatus();
                formatted.add(actual);
                inner.add(msg);
            }
            return formatted;
        }
        public List<lastMessage> queryUsers(){
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
        public List<lastMessage> queryUsers(String find){
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

