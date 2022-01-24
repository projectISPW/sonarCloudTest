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
        connDB = new ConnectionDBMS();
        query = new Query();
    }
    public void attach(String input, List<String> list) {
        boolean bool = true;
        for (String elem : list) {
            if (elem.equals(input)) bool = false;
        }
        if (bool) list.add(input);
    }
    public List<String> paramSearch(String uid, int emp, int hum, int pos) {
        Statement stmt = null;
        ResultSet rst = null;
        List<String> ret = new ArrayList<>();
        try {
            stmt = connDB.connection(stmt);
            rst = query.searchAll(stmt, uid, emp, hum, pos);
            while (rst.next()) {
                attach(rst.getString(UID), ret);
            }
            return (ArrayList<String>) ret;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            connDB.closeRSTSTMT(rst, stmt);
        }
    }
    public boolean addVisited(String userid, String userid2) {
        Statement stmt = null;
        ResultSet rst = null;
        boolean bool = true;
        String [] out=new String[4];
        try {
            stmt = connDB.connection(stmt);
            query.newLine(stmt,userid);
            rst = query.getVisited(stmt, userid);
            while (rst.next()) {
              out[1]=rst.getString(1);
              out[2]=rst.getString(2);
              out[3]=rst.getString(3);
            }
            out[0]=userid2;
            for(int i=0;i<4;i++){
                for(int j=i+1;j<4;j++){
                    if(out[j]!=null && out[i]!=null && out[i].equals(out[j]) ){
                        out[j]=null;
                    }
                }
            }
            bool=query.setVisited(stmt, userid,out);
            if(bool)bool=query.incremVisit(stmt,userid2);
            return bool;
        } catch (SQLException throwables) {
            return false;
        } finally {
            connDB.closeRSTSTMT(rst, stmt);
        }
    }
    public int[] getnVisit(String userid) {
        Statement stmt = null;
        ResultSet rst = null;
        int [] ret = new int [2];
        try {
            stmt = connDB.connection(stmt);
            query.newLine(stmt,userid);
            System.out.println(" i am survived");
            rst = query.getnVisit(stmt, userid);
            if (rst.next()) ret[0]=Integer.parseInt(rst.getString(1));
            System.err.println(ret[0]);
            rst = query.getnRows(stmt);
            if (rst.next()) ret [1]=Integer.parseInt(rst.getString(1));
            System.err.println(ret[1]);
            return ret;
        } catch (Exception throwables) {
            return new int [2];
        } finally {
            connDB.closeRSTSTMT(rst, stmt);
        }
    }
    public ArrayList<String> getVisit(String userid) {
        Statement stmt = null;
        ResultSet rst = null;
        int ind = 1;
        ArrayList<String> users = new ArrayList<>();
        try {
            stmt = connDB.connection(stmt);
            rst = query.getVisited(stmt, userid);
            while (rst.next()) {
                users.add(rst.getString(ind++));
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        } finally {
            connDB.closeRSTSTMT(rst, stmt);
        }
    }

}