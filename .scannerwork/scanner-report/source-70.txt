package progettoispw.letmeknow.controller.form;

import progettoispw.letmeknow.controller.ConnectionDB;
import progettoispw.letmeknow.controller.chat.Message;

import java.sql.*;
import java.util.Vector;

public class FormSQL extends Query{
    private ConnectionDB conn=new ConnectionDB() ;
    private Statement stmt=conn.getStatement();
    private ResultSet rst;
    public int [] queryResult (String userid, int formid){
        ResultSet rst=queryResults(stmt, userid, formid);
        try {
            int [] array=new int[6];
            int indice=0;
            while (rst.next()) {
                for(int i=0;i<6;i++){
                    array[i]=Integer.parseInt(rst.getString(i+3));
                }
            }
            rst.close();
            return array;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Boolean setAnswer(String userid, int formid, int[] answer, int complete){
        return(setResults(stmt,userid,formid,answer,complete));
    }
    public int [] queryParam (String userid){
        try{
            int [] param=new int[3];
            int indice=0;
            rst=takeParam(stmt,userid);
            while(rst.next()){
                param[indice++]=Integer.parseInt(rst.getString(indice));
                param[indice++]=Integer.parseInt(rst.getString(indice));
                param[indice++]=Integer.parseInt(rst.getString(indice));
                //param[indice]=Integer.parseInt(rst.getString(indice));
            }
            return param;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public int [] queryParamForm (String userid,int formid){
        try{
            int [] param=new int[3];
            int indice=0;
            rst=takeParamForm(stmt,userid,formid);
            while(rst.next()){
                param[indice++]=Integer.parseInt(rst.getString(indice));
                param[indice++]=Integer.parseInt(rst.getString(indice));
                param[indice++]=Integer.parseInt(rst.getString(indice));
                //param[indice]=Integer.parseInt(rst.getString(indice));
            }
            return param;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Boolean close(String userid,int formid){
        int [] param=queryParam(userid);
        return close(stmt,userid,formid,param);
    }
    public String queryData(String userid,int formid){
        try {
            String out;
            rst=takeDate(stmt,userid,formid);
            while(rst.next()){
                out=rst.getString(1);
                return out;
            }} catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Boolean setCalculated(String userid,int formid){
        return setCalculated(stmt,userid,formid);
    }
    public ResultSet newForm(String userid){
        return newForm(stmt,userid);
    }

}
