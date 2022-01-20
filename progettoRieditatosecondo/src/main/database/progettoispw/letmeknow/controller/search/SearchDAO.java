package progettoispw.letmeknow.controller.search;

import progettoispw.letmeknow.controller.ConnectionDBMS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchDAO implements SearchMeta {
    ConnectionDBMS connDB;
    Query query;
    public SearchDAO() {
        connDB= new ConnectionDBMS();
        query=new Query();
    }
    public void attach(String input,ArrayList<String> list){
        boolean bool=true;
        for(String elem:list){
            if(elem.equals(input))bool=false;
        }
        if(bool)list.add(input);
    }
    public ArrayList<String> paramSearch(String uid, int emp, int hum, int pos){
        Statement stmt=null;
        ResultSet rst=null;
        List<String> ret=new ArrayList<>() ;
        try {
            stmt=connDB.connection(stmt);
            rst=query.searchAll(stmt,uid,emp,hum,pos);
            while(rst.next()) {
                attach(rst.getString(UID), (ArrayList<String>) ret);
            }
            return (ArrayList<String>) ret;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
    }
    public ArrayList<String> searchGoal(String userid,String goal){
        Statement stmt=null;
        ResultSet rst=null;
        List <String> ret=new ArrayList<>() ;
        try {
            stmt=connDB.connection(stmt);
            rst=query.searchDataQuery(stmt,userid,TAG,goal);
            while(rst.next()) {
                attach(rst.getString(UID), (ArrayList<String>) ret);
            }
            return (ArrayList<String>) ret;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
    }
    public ArrayList<String> searchDescr(String userid,String goal){
        Statement stmt=null;
        ResultSet rst=null;
        List<String> ret=new ArrayList<>();
        try {
            stmt=connDB.connection(stmt);
            rst=query.searchDataQuery(stmt,userid,DESCRIPTION,goal);
            while(rst.next()) {
                attach(rst.getString(UID), (ArrayList<String>) ret);
            }
            return (ArrayList<String>) ret;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
    }
}
