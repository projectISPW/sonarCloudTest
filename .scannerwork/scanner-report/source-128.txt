package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.usruser.UsrUser;

public class HomepageEditController {
    UsrUser user;
    HomepageController compare;
    public HomepageEditController(){
        user = ControllerClass.getUserUSR();
        compare=new HomepageController(false);
    }
    public String getUserID(){
        return user.getUserid();
    }
    public boolean setDes(String input) {
        if(!compare.getDescription().equals(input)){
            return user.setPersonalDes(input);
        }
        return true;
    }
    public boolean setGoal(String input){
        if(!compare.getGoal().equals(input)){
            return user.setPersonalGoal(input);
        }
        return true;
    }
    public boolean setDate(String input){
        return user.setPersonalData(input);
    }
    public boolean setTag(String input){
        if(compare.getTag()==null){
            return user.setPersonalTag(input);
        }
        if(!compare.getTag().equals(input)){
            return user.setPersonalTag(input);
        }
        return true;
    }
}
