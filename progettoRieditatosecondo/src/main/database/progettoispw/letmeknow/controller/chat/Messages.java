package progettoispw.letmeknow.controller.chat;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Messages implements MessagesMeta {
    private String userid;
    private MessagesSQL messageData;
    private ResultSet rst;
    private Vector<Message> lastmessages;
    private Vector<Message> messages;
    private Vector<String>users;
    private Vector<String>searchUsers;
    private Vector<Message>localSearch;
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

    public Vector<Message> getLast(){
        getUSR();
        lastmessages =new Vector<>();
        for(String user:users){
           chat(user);
           attach(messages.lastElement(),lastmessages);
       }
       return lastmessages;
    }
    public Message getLast(String usr){
        lastmessages =new Vector<>();
        chat(usr);
        return (messages.lastElement());
    }

    public Vector<String> getUsers() {
       return users;
    }

    public void attach(Message msg,Vector<Message> vec){
       vec.add(msg);
    }
    public void attach(String usr,Vector<String>vec){
        vec.add(usr);
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
            users=new Vector<>();
            while (rst.next()) {
                attach(rst.getString(TO));
                attach(rst.getString(FROM));
            }
            users.remove(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Vector<Message> chat(String user2){
        try {
            rst=messageData.getSRchat(userid,user2);
            messages=new Vector<>();
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
        messagesALL=new Vector<Message>();
        messagesALL=messageData.getSRmsg(userid);
    }
    public void search (String word) {
        localSearch=new Vector<>();
        searchUsers=new Vector<>();
        for (Message msg: messagesALL) {
            if(msg.getText().contains(word)) {
                attach(msg,localSearch);

            }
        }
    }

    public Vector<Message> getLocalSearch() {
        return localSearch;
    }
    public Vector<String> getSearchUsers() {
        return searchUsers;
    }
}
