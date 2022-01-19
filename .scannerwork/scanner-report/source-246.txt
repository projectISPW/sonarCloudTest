package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.SettingsController;

public class SettingsBean {
    SettingsController controller;
    SignupBean checkBean;
    public SettingsBean(){
        controller=new SettingsController();
        checkBean=new SignupBean();
    }
    public void closeConnection(){
        controller.closeConnection();
    }
    public boolean setPassword(String pswd,String confirmpswd){
        if(checkBean.checkPswd(pswd,confirmpswd))return controller.setPassword(pswd);
        else return false;
    }
    public boolean setEmail(String input){
        if(checkBean.checkEmail(input,true))return controller.setEmail(input);
        else return false;
    }
    public boolean setFeed(String input){
        return controller.feed(input);
    }
}
