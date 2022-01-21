package progettoispw.letmeknow.controller.utentiusr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    protected ResultSet selectUser(Statement stmt, String iduser )throws SQLException {
        String sql=String.format(" SELECT *\n FROM utenti \n where userid = '%s' ;\n",iduser);
        //System.out.println(sql);
        return stmt.executeQuery(sql);
    }

    protected boolean setDB(Statement stmt, String iduser ,String what,String edit){
        try {
            String sql=String.format(" UPDATE  `utenti`\n set `%s`='%s'\n WHERE (`userid` = '%s') ;\n",what,edit,iduser);
            //System.out.println(sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    protected Boolean setParams(Statement stmt,String uid,int [] param){
        try {
            String sql=String.format("UPDATE `utenti` SET `empathy` = '%d', `humor` = '%d', `positivity` = '%d' WHERE (`userid` = '%s'); ",param[0],param[1],param[2],uid);
            System.out.println(sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }
    protected ResultSet queryResult(Statement stmt, String uid) {
        try {
            String sql=String.format(" SELECT * FROM forms where `userid`=%s ;",uid);
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    protected boolean setCalculated(Statement stmt,String uid,int formid){
        try {
            String sql=String.format(" UPDATE `forms` SET `calculated` = '0' WHERE (`formid` = '%d') and (`userid` = '%s');",formid,uid);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }
}
