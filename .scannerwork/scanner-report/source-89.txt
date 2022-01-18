package progettoispw.letmeknow.controller.utenti;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    protected ResultSet selectUser(Statement stmt, String iduser )throws SQLException {
        String sql=String.format(" SELECT *\n FROM utenti \n where userid = '%s' ;\n",iduser);
        //System.out.println(sql);
        return stmt.executeQuery(sql);
    }
    protected ResultSet selectUser(Statement stmt,String what, String input )throws SQLException {
        String sql=String.format(" SELECT *\n FROM utenti \n WHERE %s = '%s' ;\n",what,input);
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }

    protected boolean setDB(Statement stmt, String iduser ,String what,String edit){
        try {
            String sql=String.format(" UPDATE  utenti\n set %s='%s'\n WHERE userid = '%s' ;\n",what,edit,iduser);
            //System.out.println(sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    protected void setDataQuery(Statement stmt, String iduser ,String edit)throws SQLException {
        String sql=String.format(" UPDATE `utenti` SET `by` = '%s' WHERE (`userid` = '%s');",edit,iduser);
        //System.out.println(sql);
        stmt.executeUpdate(sql);
        return ;
    }
    protected ResultSet queryUid(Statement stmt) throws SQLException {
        String sql=String.format(" SELECT userid FROM utenti ");
        return stmt.executeQuery(sql);
    }

    protected void newLine(Statement stmt,String uid,String password, String type ,int [] val,String description,String email,String goal) throws SQLException{
        String sql=String.format("INSERT INTO `utenti` (`userid`, `password`, `type`, `email`, `empathy`, `humor`, `positivity`, `description`, `goal`,`by`)" +
                                                        " VALUES ('%s',         '%s',      '%s',       '%s',    '%d',       '%d',      '%d','%s','%s',current_date+INTERVAL 6 month )\n",
                                                                    uid,password,type,email,val[0],val[1],val[2],description,goal);
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return ;
    }
    protected void newLine(Statement stmt, String uid,String password, String type, String email) throws SQLException {
        String sql=String.format("INSERT INTO `utenti` (`userid`, `password`, `type`, `email`)" +
                                " VALUES ('%s',         '%s',      '%s',       '%s')\n",
                                            uid,password,type,email);
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return ;
    }
    protected Boolean setParams(Statement stmt,String uid,int [] param){
        try {
            String sql=String.format("UPDATE `utenti` SET `empathy` = '%d', `humor` = '%d', `positivity` = '%d' WHERE (`userid` = '%s'); ",param[0],param[1],param[2],uid);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }

    protected ResultSet queryResult(Statement stmt, String uid) throws SQLException {
        String sql=String.format(" SELECT * FROM forms where `userid`=%s ;",uid);
        return stmt.executeQuery(sql);
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
    protected boolean feed(Statement stmt,String from,String what){
        try {
            String sql=String.format(" INSERT INTO suggest (`from`, `content`,`when`) VALUES ('%s', '%s',CURRENT_TIMESTAMP);",from,what);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    


}
