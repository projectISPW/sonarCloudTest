package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.lastMessage;
import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;

import java.sql.SQLException;
import java.util.Vector;
public class ISCController {
        ControllerClass factory;
        private Vector<String> founded;
        private Integer count;
        private Integer nVal;
        private Vector<Message>lmsgs;
        private Vector<Message>msgs;
        private Messages chat;
        public ISCController(Integer n){
            factory=new ControllerClass();
            factory.controllerChat();
            if(factory.getSearch()==null)factory.controllerUsers();
            chat= factory.getChat();
            lmsgs=chat.getLast();
            founded=chat.getUsers();
            msgs=null;
            nVal=n;
            count=0;
        }
    public ISCController(){
        factory=new ControllerClass();
        factory.controllerChat();
        if(factory.getSearch()==null)factory.controllerUsers();
        chat= factory.getChat();
        lmsgs=chat.getLast();
        founded=chat.getUsers();
        msgs=null;
        nVal=0;
        count=0;
    }
        public String getUid(){
            return chat.getUserid();
        }
         Vector<lastMessage>formatted;
        public void attach(lastMessage elem){
            formatted.add(elem);
        }
        lastMessage actual;
        public Vector<lastMessage> queryUsers(){
            int indice;
            actual = null;
            formatted = new Vector<>();
            if(nVal==0 && msgs==null){
                indice=0;
                for (String usr : founded) {//search activated in list users iterf1
                    System.out.println("i am here "+indice);
                    actual = new lastMessage(usr, lmsgs.get(indice++));
                    actual.getStatus();
                    attach(actual);
                }
            }
            else if(nVal==0){
                for (Message msg : msgs) {
                    actual = new lastMessage(msg.getSender()+"||"+msg.getReciver(), msg);
                    attach(actual);
                }
            }
            else if(msgs==null) {//list users in interf1
                count = check(count, lmsgs);
                for (String usr : founded) {
                    indice = founded.indexOf(usr);
                    if (indice >= count && indice < count + nVal) {
                        actual = new lastMessage(usr, lmsgs.get(indice));
                        // actual.getStatus();
                        attach(actual);
                    }
                }
            }

            else {//search activated in list users iterf1
                count = check(count, msgs);
                for (Message msg : msgs) {
                    indice = msgs.indexOf(msg);
                    if (indice >= count && indice < count + nVal) {
                        actual = new lastMessage(msg.getSender()+"||"+msg.getReciver(), msg);
                        //actual.getStatus();
                        attach(actual);
                    }
                }
            }
                count+=nVal;
                System.out.println("_____________________________________-");
                return formatted;
        }

        private Integer check(Integer count,Vector<Message> list) {
            if(count>=list.toArray().length){
                return count=0;
            }
            return count;
        }
        public void who(String usr){
            chat.setTouched(usr);
        }
        public void search(String find){
            factory.getChat().search(find);
            msgs=chat.getLocalSearch();
            for(Message msg:msgs)msg.getStatus();
            count=0;
            queryUsers();
        }
        public void reset(){
            msgs=null;
            count=0;
            queryUsers();
        }
}

