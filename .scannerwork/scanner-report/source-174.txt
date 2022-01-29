package progettoispw.letmeknow.controller.utentiusr;

import progettoispw.letmeknow.controller.ConnectionDBMS;
import progettoispw.letmeknow.controller.form.FormMeta;
import progettoispw.letmeknow.controller.utenti.SalvaUtenteMeta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements SalvaUtenteMeta, FormMeta {
    ConnectionDBMS connDB;
    Query query;
    public UserDAO() {
        connDB= new ConnectionDBMS();
        query=new Query();
    }
    public String [] selectUser(String uid){
        Statement stmt=null;
        ResultSet rst=null;
        String [] ret=new String [7];
        try {
            stmt=connDB.connection(stmt);
            rst=query.selectUser(stmt,uid);
            while(rst.next()) {
                for(int i=0;i<7;i++)ret[i]= rst.getString(EMP+i);
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[]{"1","1","1",null,null,null,null};
        }finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
    }
    public boolean setDescription(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,DESCRIPTION,input);
        }finally{
            connDB.closeSTMT(stmt);
        }

    }
    public boolean setGoal(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,GOAL,input);
        }finally{
            connDB.closeSTMT(stmt);
        }

    }
    public boolean setTag(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,TAG,input);
        }finally{
            connDB.closeSTMT(stmt);
        }

    }
    public boolean setData(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,BY,input);
        } finally{
            connDB.closeSTMT(stmt);
        }

    }
    private int average(int val,int divisor){
        val=val/divisor;
        if(val>5)return 5;
        else if(val <1 )return 1;
        else return val;
    }
    public boolean getResult(String userid,int emp,int hum,int pos){
        Statement stmt=null;
        ResultSet rst=null;
        ArrayList<Integer> calculated=new ArrayList<>();
        char[] about;
        boolean edited=false;
        boolean check=true;
        int empMed = 0;
        int humMed = 0;
        int posMed = 0;
        int size=-1;
        try {
            stmt=connDB.connection(stmt);
            rst=query.queryResult(stmt,userid);
            while (rst.next()) {
                if (rst.getString(CALCULATED).equals("1")) {
                    edited = true;
                    about = rst.getString(ABOUT).toCharArray();
                    for (int i = 0; i < about.length; i++) {
                        switch (about[i]) {
                            case '1': {
                                empMed += Integer.parseInt(rst.getString(3 + i));
                                break;
                            }
                            case '2': {
                                humMed += Integer.parseInt(rst.getString(3 + i));
                                break;
                            }
                            case '3': {
                                posMed += Integer.parseInt(rst.getString(3 + i));
                                break;
                            }
                        }
                    }
                    calculated.add(Integer.parseInt(rst.getString(1)));
                }
            }
            size=calculated.size()+1;
            for(Integer id :calculated)if(check)check=query.setCalculated(stmt,userid,id);
            if(edited && check){
                emp=average(emp+empMed,size+1);
                hum=average(hum+humMed,size+1);
                pos=average(pos+posMed,size+1);
                System.out.println("new emp"+emp+"new hum"+hum+"new pos"+pos+"form scansionati"+size);
                check=query.setParams(stmt,userid,new int[]{emp,hum,pos});
            }
            if(!check)return false;
            return true;
        }catch (SQLException e) {
                e.printStackTrace();
                return false;
        }finally{
                connDB.closeRSTSTMT(rst,stmt);
        }

    }

}
