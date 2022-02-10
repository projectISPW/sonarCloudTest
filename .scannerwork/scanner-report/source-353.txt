package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.*;

public class LoginBean {
    LoginController controller;
    public LoginBean(){
        controller=new LoginController();
    }
    public boolean getLog(String user,String password){
        return controller.getLog(user,password);
    }
    public String getType(){
        return controller.getType();
    }
}
