package progettoispw.letmeknow.controller.search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    protected ResultSet selectUser(Statement stmt, String iduser )throws SQLException {
        String sql=String.format(" SELECT *\n FROM utenti \n where userid = '%s' ;\n",iduser);
       // System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    protected ResultSet searchVal(Statement stmt, String what , String iduser,int value) {
       try {
           String sql = String.format("SELECT userid,'%s' " +
                   "FROM utenti " +
                   "WHERE type='usr' and '%s'>=%d and userid != '%s'", what, what, value, iduser);
           //System.out.println(sql);
           return stmt.executeQuery(sql);
       }catch (SQLException throwables) {
           System.err.println("errore durante la searchVal");
           throwables.printStackTrace();
           return null;
       }
    }
    protected ResultSet searchAll(Statement stmt,int emp, int hum,int pos,String iduser)  {
        try{String sql=String.format("SELECT userid " +
                        "FROM utenti WHERE type='usr' and " +
                        "empathy>=%d and humor>=%d and positivity >=%d and userid != '%s' and type='usr'",
                        emp,hum,pos,iduser);
            //System.out.println(sql);
            return stmt.executeQuery(sql);
        }catch (SQLException throwables) {
            System.err.println("errore durante la ricerca parametrica ");
            throwables.printStackTrace();
            return null;
        }
    }
    protected ResultSet searchDataQuery(Statement stmt, String iduser ,String what,String input){
        try {
            String sql = String.format(" SELECT userid " +
                    "FROM utenti " +
                    "where %s = '%s' and userid!='%s' and type= 'usr' ;\n", what, input, iduser);
            //System.out.println(sql);
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            System.err.println("errore durante la ricerca"+what);
            throwables.printStackTrace();
            return null;
        }
    }

}
