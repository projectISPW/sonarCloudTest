package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.lastMessage;
import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;

import java.util.ArrayList;
import java.util.List;
public class ISCController {
        private ArrayList<String> founded;
        private Integer count;
        private Integer nVal;
        private ArrayList<Message>lmsgs;
        private ArrayList<Message>msgs;
        private Messages chat;
        public ISCController(Integer n){
            ControllerClass.controllerChat();
            if(ControllerClass.getSearch()==null)ControllerClass.controllerUsers();
            chat= ControllerClass.getChat();
            lmsgs= (ArrayList<Message>) chat.getLast();
            founded= (ArrayList<String>) chat.getUsers();
            msgs=null;
            nVal=n;
            count=0;
        }
    public ISCController(){
        ControllerClass.controllerChat();
        if(ControllerClass.getSearch()==null)ControllerClass.controllerUsers();
        chat= ControllerClass.getChat();
        lmsgs= (ArrayList<Message>) chat.getLast();
        founded= (ArrayList<String>) chat.getUsers();
        msgs=null;
        nVal=0;
        count=0;
    }
        public String getUid(){
            return chat.getUserid();
        }
        lastMessage actual;
        private List<lastMessage> getListV1(){
            //lista utenti con ultimo messaggio per la interfaccia 2
            int indice=0;
            ArrayList <lastMessage> formatted  = new ArrayList<>();
            for (String usr : founded) {
                actual = new lastMessage(usr, lmsgs.get(indice++));
                actual.getStatus();
                formatted.add(actual);
            }
            return formatted;
        }
        private List<lastMessage> getListV2(){
        //ricerca messaggi sulla lista utenti 2
            ArrayList <lastMessage> formatted  = new ArrayList<>();
            for (Message msg : msgs) {
                actual = new lastMessage(msg.getSender()+"||"+msg.getReciver(), msg);
             formatted.add(actual);
            }
            return formatted;
        }
        private List<lastMessage>getListV3(){
            //lista utenti con ultimo messaggio per la interfaccia 1
            count = check(count, lmsgs);
            ArrayList <lastMessage> formatted  = new ArrayList<>();
            int indice=0;
            for (String usr : founded) {
                indice = founded.indexOf(usr);
                if (indice >= count && indice < count + nVal) {
                    actual = new lastMessage(usr, lmsgs.get(indice));
                    formatted.add(actual);
                }
            }
            count+=nVal;
            return formatted;
        }
        private List<lastMessage>getListV4(){
            count = check(count, msgs);
            ArrayList <lastMessage> formatted  = new ArrayList<>();
            int indice=0;
            for (Message msg : msgs) {
                indice = msgs.indexOf(msg);
                if (indice >= count && indice < count + nVal) {
                    actual = new lastMessage(msg.getSender()+"||"+msg.getReciver(), msg);
                    formatted.add(actual);
                }
            }
            count+=nVal;
            return formatted;
        }
        public List<lastMessage> queryUsers(){
            if(nVal==0 && msgs==null){
               return getListV1();
            }
            else if(nVal==0){
                return getListV2();
            }
            else if(msgs==null) {//list users in interf1
                return getListV3();
            }
            else {//search activated in list users iterf1
                return getListV4();
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
        public void search(String find){
            ControllerClass.getChat().search(find);
            msgs=chat.getLocalSearch();
            count=0;
            queryUsers();
        }
        public void reset(){
            msgs=null;
            count=0;
            queryUsers();
        }
}

