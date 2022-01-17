package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class EditProfileController {
    ControllerClass factory;
    UtenteUsr user;
    String newStr;
    public EditProfileController(){
        newStr=null;
        factory=new ControllerClass();
        user = factory.getUserUSR();
    }
    public String getUserID(){
        return user.getUserid();
    }
    public void setNewStr(String input) {
        this.newStr = input;
        user.setPersonalDes(newStr);
    }
    public void setGoal(String obbInput , String tagInput, Integer [] scadenzaInput){
        user.setPersonalGoal(obbInput);
        user.setPersonalTag(tagInput);
        user.setPersonalData(scadenzaInput);
    }
}
