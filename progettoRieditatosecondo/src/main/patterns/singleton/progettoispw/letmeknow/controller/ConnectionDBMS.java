package progettoispw.letmeknow.controller;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDBMS {
    private String  user ;
    private String password;
    private String dburl ;
    private String driverclassname ;
    private java.sql.Connection conn = null;
    private static int numConnection;
    public ConnectionDBMS(){
        user = "uf56pst70onxcz68";
        password = "N5bkvOZY2AhFpYZYu3w7";
        dburl = "jdbc:mysql://uf56pst70onxcz68:N5bkvOZY2AhFpYZYu3w7@b16kdsy1yce6nyrrldqg-mysql.services.clever-cloud.com:3306/b16kdsy1yce6nyrrldqg";
        driverclassname = "com.mysql.cj.jdbc.Driver";
    }
    public Statement connection(Statement stmt){
        if(numConnection<1) {
            try {
                Class.forName(driverclassname);//recupera dinamicamente il driver , prende la classe dal class path
                conn = DriverManager.getConnection(dburl, user ,password);//quando ho get connection ho il driver caricato
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                increm();
                return stmt;
            } catch (Exception throwables) {
                throwables.printStackTrace();
                closeConnection(stmt);
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
