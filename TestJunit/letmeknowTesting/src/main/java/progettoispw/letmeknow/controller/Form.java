package progettoispw.letmeknow.controller;


import progettoispw.letmeknow.controller.psyuser.PsyUser;
import progettoispw.letmeknow.controller.usruser.UsrUser;

import java.time.LocalDate;

public class Form {
    public  int takeForm(String userid){
        ControllerClass.controllerUser(userid);
        ControllerClass.setResultForm();
        return ControllerClass.getResultForm().getFormid();
    }
    public int [] getParam(String userid){
        int [] param=new int[3];
        UsrUser user=new UsrUser(userid);
        param[0]=user.getEmp();
        param[1]=user.getHum();
        param[2]=user.getOpt();
        return param;
    }
    public int[] setDecremForm(String userid) {
        takeForm(userid);
        ControllerClass.getResultForm().setAnswers(new int [] {1,1,1,1,1,1});
        return ControllerClass.getResultForm().getParam();
    }
    public int []setIncremForm(String userid){
        takeForm(userid);
        ControllerClass.getResultForm().setAnswers(new int [] {5,5,5,5,5,5});
        return ControllerClass.getResultForm().getParam();
    }
    public int getCounterFrom(String userid,int formid){
        PsyUser user=new PsyUser(userid);
        LocalDate date= LocalDate.now();
        user.collectForms(date.getMonthValue(), date.getYear());
        return user.getCounter(formid);
    }

}
