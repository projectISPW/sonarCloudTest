package progettoispw.letmeknow.controller.chat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

    protected ResultSet selectUser(Statement stmt, String iduser , String what)throws SQLException {
        String sql=String.format(" SELECT * \n FROM messages where %s = '%s' ",what,iduser);
        //System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    protected ResultSet selectMessages(Statement stmt,String  input,String userid) throws SQLException {
        String sql=String.format("SELECT * FROM messages  WHERE text='%s' and (sender=%s or reciver =%s ) ",input,userid,userid);
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    protected ResultSet selectUserRSALL(Statement stmt, String iduser )throws SQLException {
        String sql=String.format(" SELECT * \n FROM messages where reciver = '%s' or sender = '%s' ",iduser,iduser);
       // System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    protected ResultSet selectUserRS(Statement stmt, String user1 , String user2)throws SQLException {
        String sql=String.format(" SELECT *" +" FROM messages \n" +
                "where (reciver = '%s' and sender = '%s') or \n" +
                "(reciver = '%s' and sender = '%s');",user1,user2,user2,user1);
       // System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    protected void newMSG(Statement stmt, String from , String who ,String text)throws SQLException {
        String sql=String.format("INSERT INTO `messages` (`datetime`, `sender`, `reciver`, `text`) VALUES (CURRENT_TIMESTAMP, '%s', '%s', '%s')",from,who,text);
       // System.out.println(sql);
        stmt.executeUpdate(sql);
    }

}
