package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utentipsy.Query;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDBMS {
    private String  User ;
    private String Pass ;
    private String DB_URL ;
    private String DRIVER_CLASS_NAME ;
    private Query query=new Query();
    private java.sql.Connection conn = null;
    private static int numConnection;
    public ConnectionDBMS(){
        User = "uf56pst70onxcz68";
        Pass = "N5bkvOZY2AhFpYZYu3w7";
        DB_URL = "jdbc:mysql://uf56pst70onxcz68:N5bkvOZY2AhFpYZYu3w7@b16kdsy1yce6nyrrldqg-mysql.services.clever-cloud.com:3306/b16kdsy1yce6nyrrldqg";
        DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    }
    public Statement Connection(Statement stmt){
        if(numConnection<1) {
            java.sql.Connection conn ;
            try {
                Class.forName(DRIVER_CLASS_NAME);//recupera dinamicamente il driver , prende la classe dal class path
                conn = DriverManager.getConnection(DB_URL, User, Pass);//quando ho get connection ho il driver caricato
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                increm();
                return stmt;
            } catch (Exception throwables) {
                throwables.printStackTrace();
                return null;
            }
        }
        return null;
    }
    private static void decrem(){
        numConnection--;
    }
    private static void increm(){
        numConnection++;
    }
    public void closeConnection(Statement stmt) {
        try {
            if(stmt!=null)stmt.close();
            if(conn!=null)conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            decrem();
            //"GESTIONE CONNESSIONE FALLITA "
        }
    }
    public void closeConnection(ResultSet rst,Statement stmt) {
        try {
            if(rst!=null)rst.close();
            if(stmt!=null)stmt.close();
            if(conn!=null)conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            decrem();
            //"GESTIONE CONNESSIONE FALLITA "
        }
    }
}
