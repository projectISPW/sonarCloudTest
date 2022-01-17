package progettoispw.letmeknow.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private String User = "uf56pst70onxcz68";
    private String Pass = "N5bkvOZY2AhFpYZYu3w7";
    private String DB_URL = "jdbc:mysql://uf56pst70onxcz68:N5bkvOZY2AhFpYZYu3w7@b16kdsy1yce6nyrrldqg-mysql.services.clever-cloud.com:3306/b16kdsy1yce6nyrrldqg";
    private String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static Statement stmt = null;
    private Statement connection(){
        java.sql.Connection conn = null;
        try {
            System.out.println("creata connessione");
            Class.forName(DRIVER_CLASS_NAME);//recupera dinamicamente il driver , prende la classe dal class path
            conn = DriverManager.getConnection(DB_URL, User, Pass);//quando ho get connection ho il driver caricato
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Statement getStatement(){
        System.out.println("cerco connessione ");
        if (stmt==null){
            connection();
        }
        return stmt;
    }
    public void close(){

    }
}
