package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

public class EditProfileController {
    UtenteUsr user;
    String newStr;
    public EditProfileController(){
        newStr=null;
        user = ControllerClass.getUserUSR();
    }
    public String getUserID(){
        return user.getUserid();
    }
    public void setNewStr(String input) {
        this.newStr = input;
        user.setPersonalDes(newStr);
    }
    public void setGoal(String obbInput , String tagInput, Integer [] dueDateInput){
        user.setPersonalGoal(obbInput);
        user.setPersonalTag(tagInput);
        user.setPersonalData(dueDateInput);
    }
}
