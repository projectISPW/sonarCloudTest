package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.*;

public class LoginBean {
    private LoginController controller;
    public LoginBean (String user){
        controller=new LoginController(user);
    }
    public String getLog(String password){
        return  controller.tornaLog(password);
    }
}
