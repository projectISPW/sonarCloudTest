package progettoispw.letmeknow.bean;


import progettoispw.letmeknow.controller.RecoverPswdController;

import static java.lang.Thread.sleep;

public class RecoverPswdBean {
    RecoverPswdController controller;
    SignupBean checkBean;
    public  RecoverPswdBean(){
        checkBean=new SignupBean();
        controller=new RecoverPswdController();
    }
    public boolean sendMail(String input){
        if(checkBean.checkEmail(input,false))
        {
            return controller.sendMail(input);
        }
        return false;
    }
}
