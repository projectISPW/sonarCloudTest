package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.form.ResultForm;
import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.user.InitialUser;
import progettoispw.letmeknow.controller.psyuser.PsyUser;
import progettoispw.letmeknow.controller.usruser.UsrUser;

public class ControllerClass {
    static UsrUser userU;
    static PsyUser userP;
    static Search search;
    static Messages  chat;
    static ResultForm form;
    private ControllerClass(){
        reset();
    }
    private static void reset() {
        userU = null;
        userP = null;
        search = null;
        chat = null;
        form = null;
    }
    static void  controllerUser(String userid){//la istanzia il controller della login
        InitialUser actual =new InitialUser(userid);
        reset();
        if(actual.getType().equals("usr")){
            userU=new UsrUser(userid);
        }else {
            userP= new PsyUser(userid);
            }
        }
    public static UsrUser getUserUSR(){
        return  userU;
    }
    public static PsyUser getUserPsy(){return userP;}
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
        form=new ResultForm(userU.getUserid());
    }
    public static void setResultForm(int formid){
        form=new ResultForm(userU.getUserid(),formid);
    }
    public static ResultForm getResultForm(){
        return form;
    }

}
