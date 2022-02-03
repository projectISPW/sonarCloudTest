package progettoispw.letmeknow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import progettoispw.letmeknow.bean.SignupBean;

import java.util.Optional;


public class SignupControllerInterf1 {
    @FXML
    TextField email;
    @FXML
    TextField description;
    @FXML
    TextField goal;
    @FXML
    PasswordField pswd;
    @FXML
    PasswordField confirmpswd;
    @FXML
    Slider sl1;
    @FXML
    Slider sl2;
    @FXML
    Slider sl3;
    Slider [] sliders;
    @FXML
    Label lab1;
    @FXML
    Label lab2;
    @FXML
    Label lab3;
    @FXML
    Label emailCheck;
    @FXML
    Label pswdCheck;
    @FXML
    Label desCheck;
    @FXML
    Label slCheck;
    SignupBean bean;
    public SignupControllerInterf1(){
        bean=new SignupBean();
    }
    public SignupControllerInterf1(TextField  email,PasswordField [] passwords,Label []labels){
        bean=new SignupBean();
        this.email=email;
        this.pswd=passwords[0];
        this.confirmpswd=passwords[1];
        this.emailCheck=labels[0];
        this.pswdCheck=labels[1];

    }
    public void initialize() {
        Label [] labels = new Label[]{lab1, lab2, lab3};
        sliders=new Slider[]{sl1,sl2,sl3};
        reset();
        for (int i=0;i<3;i++) {
            int finalI = i;
            sliders[i].valueProperty().addListener((observableValue, number, t1) -> {
                labels[finalI].setText("" + (int) sliders[finalI].getValue());
                labels[finalI].setOpacity(1);
            });
        }
    }
    @FXML
    protected void goToLogin() {
        Page controller=new Page();
        controller.backTo();
    }
    private boolean check(boolean bool,Label lab){
        if(!bool)lab.setOpacity(1);
        return bool;
    }
    public  void reset(){
        emailCheck.setOpacity(0);
        pswdCheck.setOpacity(0);
        if(desCheck!=null)desCheck.setOpacity(0);
        if(slCheck!=null)slCheck.setOpacity(0);
    }

    public boolean checkMailPswd(ActionEvent event,boolean psyAcces ){
        boolean bool;
        reset();
        bool = bean.checkEmail(email.getText(), true);
        if (!check(bool, emailCheck)) return false;
        bool = bean.checkPswd(pswd.getText(), confirmpswd.getText());
        if (!check(bool, pswdCheck)) return false ;
        if(psyAcces){
            bool= bean.signupPSY(pswd.getText(), email.getText());
            if(bool)goToLogin();
             else {
                 Exceptions.exceptionSignupOccurred(event);
            }
        }
        return bool;
    }
    @FXML
    protected void save(ActionEvent event) {
        boolean bool;
        String[] arr;
        int [] val;
        reset();
        if(!checkMailPswd(event,false))return;
        bool=bean.checkDescription(description.getText());
        if(!check(bool,desCheck))return;
        arr= new String[]{lab1.getText(), lab2.getText(), lab3.getText()};
        val=bean.checkVal(arr);
        bool=(val.length!=0);
        if(!check(bool,slCheck))return;
        bool=bean.signupUSR(pswd.getText(),email.getText(),val, description.getText(), goal.getText());
        if(!bool){
            Exceptions.exceptionSignupOccurred(event);
        }
        else{
            goToLogin();
        }
    }
}
