package progettoispw.letmeknow.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import progettoispw.letmeknow.PageMenu;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;
import progettoispw.letmeknow.controller.utentipsy.UtentePsy;

public class SettingsController {
    UtenteUsr userU;
    UtentePsy userP;
    ConnectionDBMS connection;
    public SettingsController(){
        userU= ControllerClass.getUserUSR();
        userP=ControllerClass.getUserPsy();
        connection=new ConnectionDBMS();
    }
    public void closeConnection(){
        connection.closeCONN();
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
    @FXML
    public void backTo(ActionEvent event){
        PageMenu controller=new PageMenu();
        controller.backTo();
    }
}
