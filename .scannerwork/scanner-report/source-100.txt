package progettoispw.letmeknow.controller.search;
import progettoispw.letmeknow.controller.ConnectionDB;

import java.sql.*;

public class SearchSQL extends Query {
    private ConnectionDB conn=new ConnectionDB() ;
    private Statement stmt=conn.getStatement();
    public ResultSet getUserData1(String userid) throws SQLException {
        return selectUser(stmt,userid);
    }
    public ResultSet search4All(String userid,int emp, int hum,int pos){
        return searchAll(stmt,emp, hum,pos,userid);
    }
    public ResultSet searchGoal(String userid, String goal) {
        return searchDataQuery(stmt,userid,"tag",goal);
    }

    public ResultSet searchDescr(String userid, String descr) {
        return searchDataQuery(stmt,userid,"description",descr);
    }
}
