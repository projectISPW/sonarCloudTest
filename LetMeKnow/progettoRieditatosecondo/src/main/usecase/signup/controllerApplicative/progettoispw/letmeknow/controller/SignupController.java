package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.user.InitialUser;

public class SignupController {
    private InitialUser user;
    public SignupController(){
        user=new InitialUser();
    }
    public boolean checkMail(String input){
        return !user.checkEmail(input);
    }
    public boolean signup(String password,String type,String email,int [] val,String description,String goal){
        return user.registrationUSR(password,email,type,val,description,goal);
    }
    public boolean signup(String password,String type,String email){
        return user.registrationPSY(password,email,type);
    }
}
