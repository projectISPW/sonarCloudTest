package progettoispw.letmeknow.controller.utentipsy;

import progettoispw.letmeknow.controller.ConnectionDB;
import progettoispw.letmeknow.controller.ConnectionDBMS;
import progettoispw.letmeknow.controller.form.FormMeta;
import progettoispw.letmeknow.controller.utenti.SalvaUtenteMeta;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements SalvaUtenteMeta,FormMeta {
    ConnectionDBMS connDB;
    Query query;
    public UserDAO() {
        connDB= new ConnectionDBMS();
        query=new Query();
    }
    public ArrayList<Form> collectForms(int month, int year) {
        Statement stmt=null;
        ResultSet rst=null;
        Form form=new Form();
        try {
            stmt=connDB.connection(stmt);
            rst=query.selectResult(stmt,month,year);
            int [] answers;
            ArrayList<Form>list=new ArrayList<>();
            while(rst.next()) {
                answers = new int[6];
                for (int i = 0; i < 6; i++) {
                    answers[i] = Integer.parseInt(rst.getString(START + i));
                }
                list= form.attach(Integer.parseInt(rst.getString(FORMID)), answers,rst.getString(2), list);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            connDB.closeConnection(rst,stmt);
        }
    }
    public boolean suggestForm(String from,String what){
        Statement stmt=null;
        try{
            stmt=connDB.connection(stmt);
            return query.suggestForm(stmt,from,what);
        } finally {
            ConnectionDB.closeConnection();
        }
    }
}
