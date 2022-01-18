package progettoispw.letmeknow.controller.form;

import progettoispw.letmeknow.controller.ControllerClass;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ResultForm implements FormMeta {
    private String userid;
    private int formid;
    private FormSQL formData;
    private int[] answers;
    private int complete;
    private int [] param;
    private String date;
    public ResultForm(String useridinp,int formidinp){
        formData=new FormSQL();
        userid=useridinp;
        formid=formidinp;
        answers= formData.queryResult(userid,formid);
        System.out.println("utente.:"+useridinp+"form.:"+formidinp);
        for(int i:answers){
            System.out.println("valore nell array" + i);
            if (i>=1){
                ++complete;
            }
        }
        if(complete==6){
            queryComplete();
        }
    }
    public ResultForm(String useridinp){
        formData=new FormSQL();
        userid=useridinp;
        formid=takeAForm();
        answers= formData.queryResult(userid,formid);
        System.out.println("utente.:"+useridinp+"form.:"+formid);
        for(int i:answers){
            System.out.println("valore nell array" + i);
            if (i>=1){
                ++complete;
            }
        }
        if(complete==6){
            queryComplete();
        }
    }
    public int getFormid() {
        return formid;
    }
    private void queryComplete(){
        UtenteUsr user= ControllerClass.getUserUSR();
        date=formData.queryData(userid,formid);
        if(date ==null){
            formData.setCalculated(userid,formid);
            user.setParams();
            formData.close(userid,formid);
            date=formData.queryData(userid,formid);
        }
        param= formData.queryParamForm(userid,formid);
        System.out.println("DATA DEL FORM RESULT"+date);
    }
    public void setRisposte(int[] input){
        complete=0;
        for(int i=0;i<input.length;i++)System.out.println(input[i]);
        for(int i:input)if(i!=-1)++complete;
        formData.setAnswer(userid,formid,input,complete);
        if(complete==6)queryComplete();
    }
    public int[] getRisposte(){
        return answers;
    }
    public int getComplete() {
        return complete;
    }
    public int[] getParam() {
        return param;
    }
    public String getDate() {
        return date;
    }
    public int takeAForm(){
        try{
            List<Integer>formid =new ArrayList<>(Arrays.asList(FORMSID));
            ResultSet rst = formData.newForm(userid);
            Integer val;
            while(rst.next()){
                val=Integer.parseInt(rst.getString(1));
                if(rst.getString(2).equals("6")==false)return val;
                formid.remove(val);
            }
            if(formid.isEmpty()==false)return formid.get(0);
            System.out.println("i am here");
            return 1;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
