package progettoispw.letmeknow.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import progettoispw.letmeknow.PageMenu;
import progettoispw.letmeknow.controller.usruser.UsrUser;
import progettoispw.letmeknow.controller.psyuser.PsyUser;

public class SettingsController {
    UsrUser userU;
    PsyUser userP;
    public SettingsController(){
        userU= ControllerClass.getUserUSR();
        userP=ControllerClass.getUserPsy();
    }
    public void closeConnection(){
        ConnectionDBMS.closeCONN();
    }
    public boolean setPassword(String input){
        if(userU!=null)return userU.setPassword(input);
        else return userP.setPassword(input);
    }
    public boolean setEmail(String input){
        if(userU!=null)return userU.setEmail(input);
        else return userP.setEmail(input);
    }
    public boolean feed(String input){
        if(userU!=null)return userU.setFeed(input);
        else return userP.setFeed(input);
    }
}
