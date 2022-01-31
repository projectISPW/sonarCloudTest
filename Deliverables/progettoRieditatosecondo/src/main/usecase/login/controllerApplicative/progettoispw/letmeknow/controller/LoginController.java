package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.user.InitialUser;
public class LoginController {
    private InitialUser utente ;
    public LoginController(String user){
        utente=new InitialUser(user);
    }
    public String tornaLog(String password){
        String str=utente.abscessType(password);
        if(str!=null){
            ControllerClass.controllerUser(utente.getUserid());
        }else{
            str=null;
        }
        return str;
    }
}
