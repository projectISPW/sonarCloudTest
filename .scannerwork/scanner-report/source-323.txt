package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.usruser.UsrUser;

public class VisitController {
    UsrUser user;
    public VisitController(){
        user= ControllerClass.getSearch().getTouched();
    }
    public String getUserid() {
        if(user!=null)return user.getUserid();
        return null;
    }
    public int returnEmpathyValues(){
        return user.getEmp();
    }
    public int returnHumorValues(){
        return user.getHum();
    }
    public int returnOptimismValues(){
        return user.getOpt();
    }
    public String returnGoal(){
        return user.getGoal();
    }
    public Integer[] returnDate(){
        return user.getDate();
    }
    public String returnTag(){
        return user.getTag();
    }
    public String returnDescription(){
        return user.getDescript();
    }

}
