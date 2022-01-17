package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.HomepagePsicologistBean;
import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utentiPsy.UtentePsy;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class ControllerClass {
    static   UtenteUsr userU;
    static  UtentePsy userP;
    static Search userRes;
    static Messages  chat;
    static HomepagePsicologistController controllerPsy;
    public void  controllerUser(String userid){//la istanzia il controller della login
        userU=null;
        userP=null;
        SalvaUtente actual =new SalvaUtente(userid);
        switch(actual.getType()){
            case "usr":{
                userU=new UtenteUsr(userid);
            }
            case "psy":{
                userP= new UtentePsy(userid);
            }
        }
    }
    public  UtenteUsr getUserUSR(){
        return  userU;    }
    public UtentePsy getUserPsy(){return userP;}
    public void  controllerUsers(){//la istanzia il controller della login
        userRes =new Search(userU.getUserid());
    }
    public  Search getSearch(){
        return  userRes;
    }
    public void controllerChat(){
        chat=new Messages(userU.getUserid());
    }
    public Messages getChat(){
        return chat;
    }

}
