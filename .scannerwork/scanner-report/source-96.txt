package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utentipsy.UtentePsy;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

public class ControllerClass {
    static   UtenteUsr userU;
    static  UtentePsy userP;
    static Search userRes;
    static Messages  chat;
    private ControllerClass(){

    }
    static void  controllerUser(String userid){//la istanzia il controller della login
        userU=null;
        userP=null;
        SalvaUtente actual =new SalvaUtente(userid);
        if(actual.getType().equals("usr")){
            userU=new UtenteUsr(userid);
        }else {
            userP= new UtentePsy(userid);
            }
        }
    public static UtenteUsr getUserUSR(){
        return  userU;
    }
    public static UtentePsy getUserPsy(){return userP;}
    public static void  controllerUsers(){//la istanzia il controller della login
        userRes =new Search(userU.getUserid());
    }
    public static Search getSearch(){
        return  userRes;
    }
    public static void controllerChat(){
        chat=new Messages(userU.getUserid());
    }
    public static Messages getChat(){
        return chat;
    }
}
