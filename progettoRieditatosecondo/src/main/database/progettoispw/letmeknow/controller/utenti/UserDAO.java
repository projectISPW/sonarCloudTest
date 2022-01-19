package progettoispw.letmeknow.controller.utenti;

import progettoispw.letmeknow.controller.ConnectionDBMS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements SalvaUtenteMeta {
    ConnectionDBMS connDB;
    Query query;
    public UserDAO() {
        connDB= new ConnectionDBMS();
        query=new Query();
    }
    public String [] selectUser(String uid){
        Statement stmt=null;
        ResultSet rst=null;
        String [] ret=new String [4];
        try {
            stmt=connDB.connection(stmt);
            rst=query.selectUser(stmt,uid);
            while(rst.next()) {
                ret[0]=rst.getString(USERID);
                ret[1]=rst.getString(PASSWORD);
                ret[2]=rst.getString(TYPE);
                ret[3]=rst.getString(EMAIL);
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[4];
        }finally{
            connDB.closeConnection(rst,stmt);
        }
    }
    public boolean setPswd(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,"password",input);
        }finally{
            connDB.closeConnection(stmt);
        }

    }
    public boolean setEmail(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,"email",input);
        }finally{
            connDB.closeConnection(stmt);
        }
    }
    public boolean checkMail(String input){
        Statement stmt=null;
        ResultSet rst=null;
        try {
            stmt=connDB.connection(stmt);
            rst= query.selectUser(stmt,"email",input);
            while (rst.next()) {
                System.out.println(rst.getString(1));
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally{
            connDB.closeConnection(stmt);
        }
    }
    public boolean registration(String uid,String password, String type, String email) {
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            query.newLine(stmt,uid,password,type,email);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally{
            connDB.closeConnection(stmt);
        }
    }
    public boolean registration(String uid,String password, String type ,int[] val,String description,String email,String goal ){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            query.newLine(stmt,uid,password,type,val,description,email,goal);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally{
            connDB.closeConnection(stmt);
        }
    }
    public boolean feed(String userid,String input){
            Statement stmt=null;
            try {
                stmt=connDB.connection(stmt);
                return query.feed(stmt,userid,input);
            } finally{
                connDB.closeConnection(stmt);
            }

        }
    public ArrayList<String> getUID() {
        Statement stmt=null;
        ResultSet rst=null;
        try {
            stmt=connDB.connection(stmt);
            ArrayList<String> uid = new ArrayList<>();
            rst = query.queryUid(stmt);
            while (rst.next()) {
                uid.add(rst.getString(USERID));
            }
            return uid;
        } catch (SQLException e) {
            System.err.println("errore nella richiesta degli userid");
            return null;
        }finally{
            connDB.closeConnection(rst,stmt);
        }
    }
    public String[] recover (String email){
        Statement stmt=null;
        ResultSet rst=null;
        String [] ret=new String[2];
        try{
            rst=query.selectUser(stmt,"email",email);
            while(rst.next()){
                ret [0]=rst.getString(USERID);
                ret [1]=rst.getString(PASSWORD);
            }
            return ret;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return new String[2];
        }finally{
            connDB.closeConnection(stmt);
        }
    }

}
