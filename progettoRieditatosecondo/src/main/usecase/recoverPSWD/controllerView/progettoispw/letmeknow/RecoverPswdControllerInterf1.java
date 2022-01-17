package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import progettoispw.letmeknow.bean.RecoverPswdBean;

import java.io.IOException;

public class RecoverPswdControllerInterf1
{
    private Page controller;
    @FXML
    TextField email;
    @FXML
    Label show;
    private  RecoverPswdBean bean;
    public void initialize(){
        controller= new PageMenu();
        bean=new RecoverPswdBean();
    }
    @FXML
    public void sendMail(ActionEvent event ){
        if(show.getOpacity()==1)show.setOpacity(0);
        String address=email.getText();
        Boolean bool=bean.sendMail(address);
        if(bool==false){
            show.setOpacity(1);
        }
    }
    @FXML
    protected void backToLogin(ActionEvent event)  {
        controller.switchTo("login/interf1.fxml",event,"login");
    }

}
