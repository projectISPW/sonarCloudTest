package progettoispw.letmeknow.controller;

public class LoginController {
    Factory factory;
    public LoginController(){
        factory=new Factory();
    }
    public boolean getLog(String userid, String password){
        return factory.tryLog(userid,password);
    }
    public String getType(){
        return factory.getUser().getType();
    }
}
