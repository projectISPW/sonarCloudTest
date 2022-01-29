package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.form.ResultForm;
import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;
import progettoispw.letmeknow.controller.utentipsy.UtentePsy;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

public class ControllerClass {
    static   UtenteUsr userU;
    static  UtentePsy userP;
    static Search search;
    static Messages  chat;
    static ResultForm form;
    private ControllerClass(){
        reset();
    }
    static private void reset() {
        userU = null;
        userP = null;
        search = null;
        chat = null;
        form = null;
    }
    static void  controllerUser(String userid){//la istanzia il controller della login
        SalvaUtente actual =new SalvaUtente(userid);
        reset();
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
    public static void  setSearch(){//la istanzia il controller della login
        if(search ==null){
            search =new Search(userU.getUserid());
        }
    }
    public static Search getSearch(){
        if(search==null){
            controllerChat();
        }
        return search;
    }
    public static void controllerChat(){
        if(chat==null){
            chat=new Messages(userU.getUserid());
        }
    }
    public static Messages getChat(){
        if(chat==null){
            controllerChat();
        }
       return chat;
    }
    public static void setResultForm(){
        System.err.println(" i am instanziated too");
        form=new ResultForm(userU.getUserid());
    }
    public static void setResultForm(int formid){
        System.err.println(" i am instanziated");
        form=new ResultForm(userU.getUserid(),formid);
    }
    public static ResultForm getResultForm(){
        return form;
    }

}
