package progettoispw.letmeknow.controller.utentiusr;
import progettoispw.letmeknow.controller.ConnectionDB;
import progettoispw.letmeknow.controller.utentiusr.Query;
import progettoispw.letmeknow.controller.utenti.SalvaUtenteMeta;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class UtenteSQL extends Query implements SalvaUtenteMeta {
    private Statement stmt;
    private ResultSet rst;
    public ResultSet getUserData(String userid)  {
        try {
            stmt=ConnectionDB.getStatement();
            return selectUser(stmt, userid);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void setDescription( String userid, String descr){
        stmt=ConnectionDB.getStatement();
        setDB(stmt,userid,"description",descr);
        ConnectionDB.closeConnection();
        return;
    }
    public void setGoal( String userid, String goal) {
        stmt=ConnectionDB.getStatement();
        setDB(stmt,userid,"goal",goal);
        ConnectionDB.closeConnection();
        return;
    }
    public void setTag( String userid, String tag){
        stmt=ConnectionDB.getStatement();
        setDB(stmt,userid,"tag",tag);
        ConnectionDB.closeConnection();
        return;
    }
    public void setData( String userid, String data) {
        try {
            stmt=ConnectionDB.getStatement();
            setDataQuery(stmt,userid,data);
            ConnectionDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    public boolean setPswd( String userid, String input)  {
        return setDB(stmt,userid,"password",input);
    }
    public boolean setEmail( String userid, String input){
        return setDB(stmt,userid,"email",input);
    }
    public String[] recover (String email){
        String [] returnStr=new String[2];
        try{
            rst=selectUser(stmt,"email",email);
            while(rst.next()){
                returnStr [0]=rst.getString(USERID);
                returnStr[1]=rst.getString(PASSWORD);
            }

            return returnStr;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> getUID() {
        try {
            ArrayList<String> uid = new ArrayList<>();
            rst = queryUid(stmt);
            while (rst.next()) {
                uid.add(rst.getString(USERID));
            }
            return uid;
        } catch (SQLException e) {
            System.err.println("errore nella richiesta degli userid");
            return null;
        }
    }
    public boolean checkEmail(String input){
        try {
            rst= selectUser(stmt,"email",input);
            while (rst.next()) {
                System.out.println(rst.getString(1));
               return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public boolean registration(String uid,String password, String type, String email) {
        try {
            newLine(stmt,uid,password,type,email);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public boolean registration(String uid,String password, String type ,int[] val,String description,String email,String goal ){
        try {
            newLine(stmt,uid,password,type,val,description,email,goal);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public ResultSet getResult(String userid){
        try {
            return rst=queryResult(stmt,userid);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void setCalculated(String userid,int formid){
        setCalculated(stmt,userid,formid);
    }
    public void setParams(String userid,int [] params ){
        setParams(stmt,userid,params);
    }
    public boolean feed(String userid,String input){
        return feed(stmt,userid,input);
    }


}
