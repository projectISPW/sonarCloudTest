package progettoispw.letmeknow.controller.chat;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Messages implements MessagesMeta {
    private String userid;
    private MessagesSQL messageData;
    private ResultSet rst;

    private ArrayList<Message> texts;
    private ArrayList<String> users;
    private ArrayList<String>searchUsers;
    private ArrayList<Message>localSearch;
    private String touched;
    public Messages(String who)  {
            userid=who;
            messageData=new MessagesSQL();
            getALL();
    }
    public String getUserid() {
        return userid;
    }
    public List<Message> getLast(){
        ArrayList<Message> lastmessages;
        getUSR();
        lastmessages =new ArrayList<>();
        for(String user:users){
           chat(user);
           attach(texts.get(texts.size()-1),lastmessages);
       }
       return lastmessages;
    }

    public List<String> getUsers() {
       return users;
    }

    public void attach(Message msg,ArrayList<Message> lis){
       lis.add(msg);
    }
    public void attach(String usr){
        if (users.contains(usr)==false) {
            users.add(usr);
        }
    }
    public void getUSR(){
        try {
            rst=messageData.getSR(userid);
            users=new ArrayList<>();
            while (rst.next()) {
                attach(rst.getString(TO));
                attach(rst.getString(FROM));
            }
            users.remove(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<Message> scanner(ResultSet rst, ArrayList<Message> list) {
        while (true) {
            try {
                if (!rst.next()) break;
                Message message=new Message();
                message.setText(rst.getString(TEXT));
                message.setSender(rst.getString(FROM));
                message.setReciver(rst.getString(TO));
                attach(message, list);
            } catch (SQLException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
        return list;
    }
    public ArrayList<Message> chat(String user2){
        rst=messageData.getSRchat(userid,user2);
        texts =new ArrayList<>();
        texts=scanner(rst,texts);
        return texts;
    }

    public void newMessage(String text,String to)  {
        messageData.newMessage(userid,to,text);
    }
    public void setTouched(String touched) {
        this.touched = touched;
    }

    public String getTouched() {
        return touched;
    }

    public ArrayList<Message> getALL(){
        ArrayList<Message> messagesALL;
        messagesALL=new ArrayList<>();
        return scanner(messageData.getSRmsg(userid),messagesALL);
    }
    public void search (String word) {
        ArrayList<Message> messagesALL=getALL();
        localSearch=new ArrayList<>();
        searchUsers=new ArrayList<>();
        for (Message msg: messagesALL) {
            if(msg.getText().contains(word)) {
                attach(msg,localSearch);
            }
        }
    }

    public ArrayList<Message> getLocalSearch() {
        return localSearch;
    }
    public ArrayList<String> getSearchUsers() {
        return searchUsers;
    }
}
