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
        show.setOpacity(0);
    }
    @FXML
    public void sendMail( ){
        show.setOpacity(0);
        String address=email.getText();
        Boolean bool=bean.sendMail(address);
        if(bool==false){
            show.setOpacity(1);
        }
        else controller.backTo();
    }
    @FXML
    protected void backToLogin(ActionEvent event)  {
        controller.backTo();
    }

}
