package progettoispw.letmeknow.controller.chat;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Messages implements MessagesMeta {
    private String userid;
    private MessagesSQL messageData;
    private ResultSet rst;
    private ArrayList<Message> lastmessages;
    private ArrayList<Message> messages;
    private ArrayList<String> users;
    private ArrayList<String>searchUsers;
    private ArrayList<Message>localSearch;
    private String touched;
    public Messages(String who)  {
        try {
            userid=who;
            messageData=new MessagesSQL();
            getALL();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserid() {
        return userid;
    }

    public ArrayList<Message> getLast(){
        getUSR();
        lastmessages =new ArrayList<>();
        for(String user:users){
           chat(user);
           attach(messages.get(messages.size()-1),lastmessages);
       }
       return lastmessages;
    }
    public Message getLast(String usr){
        lastmessages =new ArrayList<>();
        chat(usr);
        return (messages.get(messages.size()-1));
    }

    public ArrayList<String> getUsers() {
       return users;
    }

    public void attach(Message msg,ArrayList<Message> lis){
       lis.add(msg);
    }
    public void attach(String usr){
        if (users.contains(usr)==false) {
            users.add(usr);
            //System.out.println(users);
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
    public ArrayList<Message> chat(String user2){
        try {
            rst=messageData.getSRchat(userid,user2);
            messages=new ArrayList<>();
            while (rst.next()) {
                Message message=new Message();
                message.setDateSTR(rst.getString(DATETIME));
                message.setText(rst.getString(TEXT));
                message.setSender(rst.getString(FROM));
                message.setReciver(rst.getString(TO));
                //message.getStatus();
                attach(message,messages);
            }
            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void newMessage(String text,String to)  {
        try{messageData.newMessage(userid,to,text);}
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setTouched(String touched) {
        System.out.println("OHH YES YOU TOUCHED"+touched);
        this.touched = touched;
    }

    public String getTouched() {
        return touched;
    }
    private Vector<Message>messagesALL;
    public void getALL() throws SQLException {
        messagesALL=new Vector<>();
        messagesALL=messageData.getSRmsg(userid);
    }
    public void search (String word) {
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
