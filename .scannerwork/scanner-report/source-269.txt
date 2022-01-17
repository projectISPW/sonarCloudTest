package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.Factory;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;
import progettoispw.letmeknow.controller.utentiPsy.UtentePsy;

public class SettingsController {
    UtenteUsr userU;
    UtentePsy userP;
    ConnectionDB connection;
    public SettingsController(){
        ControllerClass factory=new ControllerClass();
        userU= factory.getUserUSR();
        userP=factory.getUserPsy();
    }
    public void closeConnection(){
        connection.close();
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
