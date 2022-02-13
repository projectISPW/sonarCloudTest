package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.LogBean;

public class LoginController {
    Factory factory;
    public LoginController(){
        factory=new Factory();
    }
    public void getLog(LogBean bean){
        factory.tryLog(bean.getUserid(),bean.getPassword());
    }
}
