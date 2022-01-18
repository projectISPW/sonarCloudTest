package progettoispw.letmeknow.controller.form;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query implements FormMeta {
    private String sql;
    public ResultSet queryResults(Statement stmt, String userid ,int formid) {
        ResultSet rst=null;
        try{
            sql=String.format(" SELECT * \n FROM forms where userid = '%s' and formid='%d'",userid,formid);
            rst=stmt.executeQuery(sql);
            if(!stmt.executeQuery(sql).next()){
                System.out.println("first time");
                rst.close();
                sql=String.format("INSERT INTO `forms` (`formid`, `userid`, `q1`, `q2`, `q3`, `q4`, `q5`, `q6`,`about`) VALUES ('%d', '%s', '-1', '-1', '-1', '-1', '-1', '-1','%s');",formid,userid,FORM[formid-1]);
                stmt.executeUpdate(sql);
                sql=String.format(" SELECT * \n FROM forms where userid = '%s' and formid='%d' ",userid,formid);
                return stmt.executeQuery(sql);
            }
            else {
                return stmt.executeQuery(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
    public Boolean setResults(Statement stmt, String userid, int formid, int[] answer, int complete){
        try {
            sql = String.format(" UPDATE `forms` " +
                            "SET `q1` = '%d', `q2` = '%d', `q3` = '%d', `q4` = '%d', `q5` = '%d', `q6` = '%d',`completed`='%d' WHERE (`formid` = '%d') and (`userid` = '%s');",
                    answer[0], answer[1], answer[2], answer[3], answer[4], answer[5],complete, formid, userid);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }
    public ResultSet takeParam(Statement stmt,String userid){
        try {
            String sql=String.format("SELECT empathy,humor,positivity FROM utenti where userid='%s';",userid);
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            return null;
        }
    }
    public ResultSet takeParamForm(Statement stmt,String userid,int formid){
        try {
            String sql=String.format("SELECT emp,hum,pos FROM forms where userid='%s' AND formid='%d';",userid,formid);
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            return null;
        }
    }
    public ResultSet takeDate(Statement stmt,String userid,int formid){
        try {
            String sql=String.format("SELECT `by` FROM forms where userid='%s'AND formid=%d;",userid,formid);
            System.out.println(sql);
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            return null;
        }
    }
    public Boolean setCalculated(Statement stmt,String userid,int formid){
        try {
            String sql=String.format(" UPDATE  forms \n set `calculated`=1 \n WHERE (`formid` = %d) and (`userid` = '%s');\n", formid,userid);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }
    public Boolean close(Statement stmt,String userid,int formid,int[] param){
        try {
            for(int i=0;i<param.length;i++)System.out.println(param[i]);
            String sql=String.format(" UPDATE  forms \n set `emp` = %d, `hum` = %d, `pos` = %d,`by`=CURRENT_TIMESTAMP \n WHERE (`formid` = %d) and (`userid` = '%s');\n",
                    param[0],param[1],param[2],formid,userid);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }
    public ResultSet newForm(Statement stmt,String userid){
        try {
            String sql=String.format("SELECT `formid`,`completed` FROM forms where userid='%s';",userid);
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            return null;
        }
    }

}
