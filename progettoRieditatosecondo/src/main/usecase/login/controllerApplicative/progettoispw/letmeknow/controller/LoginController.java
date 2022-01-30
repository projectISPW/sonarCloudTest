package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.user.InitialUser;
public class LoginController {
    private String userid;
    private InitialUser utente ;
    private String password;
    public LoginController(String user,String password){
        this.userid=user;
        this.password=password;
        utente=new InitialUser(userid);
    }
    public String tornaLog(){
        String str=utente.abscessType(password);
        if(str!=null){
            ControllerClass.controllerUser(userid);
        }else{
            str=null;
        }
        return str;
    }
}
