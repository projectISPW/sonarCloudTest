package progettoispw.letmeknow.controller.chat;

import progettoispw.letmeknow.controller.ConnectionDB;

import java.sql.*;

public class MessagesSQL extends Query implements MessagesMeta {
    private ConnectionDB conn=new ConnectionDB() ;
    private Statement stmt=conn.getStatement();
    public ResultSet getSR(String userid) {
        return selectUserRSALL(stmt,userid);
    }
    public ResultSet getSRchat(String user1,String user2) {
        return selectUserRS(stmt,user1,user2);
    }
    public void newMessage(String from,String to,String text ) {
        newMSG(stmt,from,to,text);
    }
    public ResultSet getSRmsg(String userid)  {
        return selectUserRSALL(stmt,userid);
    }
}
