package progettoispw.letmeknow.controller.form;

import progettoispw.letmeknow.controller.ControllerClass;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultForm {
    private String userid;
    private int formid;
    private FormDAO formData;
    private int[] answers;
    private int complete;
    private int [] param;
    private String date;
    public ResultForm(String useridinp,int formidinp){
        formData=new FormDAO();
        userid=useridinp;
        formid=formidinp;
        answers= formData.queryResult(userid,formid);
        for(int i:answers){
            if (i>=1){
                ++complete;
            }
        }
        if(complete==6){
            queryComplete();
        }
    }
    public ResultForm(String useridinp){
        formData=new FormDAO();
        userid=useridinp;
        formid=formData.takeAForm(userid);
        answers= formData.queryResult(userid,formid);
        for(int i:answers){
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
        date= formData.queryData(userid,formid);
        if(date ==null){
            formData.setCalculated(userid,formid);
            user.setParams();
            formData.close(userid,formid);
            date= formData.queryData(userid,formid);
        }
        param= formData.queryParamForm(userid,formid);
    }
    public void setRisposte(int[] input){
        complete=0;
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
}
