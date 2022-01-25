package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.*;

public class LoginBean {
    private String userid;
    private String password;
    private LoginController controller;
    public LoginBean (String user,String inputpassword){
        this.userid=user;
        this.password=inputpassword;
        controller=new LoginController(userid,password);
    }
    public String exitValue(){
        String output= controller.tornaLog();
        return output;
    }
}
