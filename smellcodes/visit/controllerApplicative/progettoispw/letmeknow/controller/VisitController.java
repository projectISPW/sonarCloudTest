package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

public class VisitController {
    UtenteUsr user;
    public VisitController(){
        user= ControllerClass.getSearch().getTouched();
    }
    public String getUserid() {
        return user.getUserid();
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
