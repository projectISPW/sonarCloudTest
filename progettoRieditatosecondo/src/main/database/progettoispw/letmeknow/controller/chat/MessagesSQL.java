package progettoispw.letmeknow.controller.chat;

import progettoispw.letmeknow.controller.ConnectionDB;

import java.sql.*;
import java.util.Vector;

public class MessagesSQL extends Query implements MessagesMeta {
    private ConnectionDB conn=new ConnectionDB() ;
    private Statement stmt=conn.getStatement();
    private ResultSet rst;
    private Vector<Message> messages;
    private Vector<String>users;
    public ResultSet getSR(String userid) throws SQLException {
        return selectUserRSALL(stmt,userid);
    }

    public ResultSet getSRchat(String user1,String user2) throws SQLException {
        return selectUserRS(stmt,user1,user2);
    }
    public void newMessage(String from,String to,String text ) throws SQLException {
        newMSG(stmt,from,to,text);
    }
    public void attach(Message msg){
        messages.add(msg);
    }
    public void attach(String usr){
        if (users.contains(usr)==false) {
            users.add(usr);
        }
    }
    public void scanner(ResultSet rst ) throws SQLException {
        while (rst.next()) {
            Message message=new Message();
            message.setDateSTR(rst.getString(DATETIME));
            message.setText(rst.getString(TEXT));
            message.setSender(rst.getString(FROM));
            message.setReciver(rst.getString(TO));
            attach(message);
        }
    }
    public void userScan(ResultSet rst,String userid ) throws SQLException {
        while (rst.next()) {
            attach(rst.getString(TO));
            attach(rst.getString(FROM));
        }
        users.remove(userid);
    }
    public void  research(String word,String userid) throws SQLException {
        messages=new Vector<>();
        users=new Vector<>();
        rst=selectMessages(stmt,word,userid);
        scanner(rst);
        userScan(rst,userid);
    }
/*
    public String getUser() {

        return User;
    }
*/
    public Vector<Message> getMessages() {
        return messages;
    }

    public Vector<Message> getSRmsg(String userid) throws SQLException {
        messages=new Vector<>();
        rst=selectUserRSALL(stmt,userid);
        scanner(rst);
        return messages;
    }
}
