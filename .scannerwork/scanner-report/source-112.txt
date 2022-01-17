package progettoispw.letmeknow.controller.utentiPsy;
import progettoispw.letmeknow.controller.ConnectionDB;
import progettoispw.letmeknow.controller.utentiPsy.Query;

import java.sql.*;
import java.util.Vector;

import static progettoispw.letmeknow.controller.utenti.Query.*;

public class UtenteSQL extends Query {
    private ConnectionDB conn=new ConnectionDB() ;
    private Statement stmt=conn.getStatement();
    public ResultSet selectResult(int month,int year){
        try {
            return selectResult(stmt,month,year);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.close();
            return null;
        }
    }
    public boolean suggestForm(String from,String what){
        return suggestForm(stmt,from,what);
    }
}