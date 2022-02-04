package progettoispw.letmeknow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import progettoispw.letmeknow.bean.LoginBean;


public class LoginControllerInterf1 {
    private Page controller= new Page();
    @FXML
    private PasswordField labPassword;
    @FXML
    private Label show;
    @FXML
    private TextField labUser;
    @FXML
    private ScrollPane scroll;
    private boolean clicked;
    public LoginControllerInterf1(){
        clicked=false;
    }
    @FXML
    protected void switchToSignup(ActionEvent event) {
        controller.switchTo("signup/interf1.fxml",event,"Signup");
    }
    @FXML
    protected void switchToSignUpPsych(ActionEvent event) {controller.switchTo("signupPsychologist/interf1.fxml",event,"Signup");}
    @FXML
    protected void switchToRecoverPswd(ActionEvent event) {controller.switchTo("recoverpassword/interf1.fxml",event,"Recover password");}
    @FXML
    protected void setSize(ActionEvent event ){controller.setSize("login/interf1.fxml",event);}
    public void initialize(){
        labUser.textProperty().addListener((observableValue, s, t1) -> {
            if(labUser.getText().equals("")){
                color(true);
            }
        });
        labPassword.textProperty().addListener((observableValue, s, t1) -> {
            if(labPassword.getText().equals("")){
                color(true);
            }
        });
    }
    @FXML
    protected void showPSWD(){
        if(!clicked){
            scroll.setOpacity(0.8);
            show.setOpacity(0.8);
            show.setText(labPassword.getText());
            clicked=true;
        }
        else{
            show.setOpacity(0);
            scroll.setOpacity(0);
            clicked=false;
        }
    }
    private void color(boolean bool){
        if(!bool){
            labUser.setStyle("-fx-border-color: red");
            labPassword.setStyle("-fx-border-color: red");
        }
        else{
            labUser.setStyle("-fx-background-color: #F2F2F2");
            labPassword.setStyle("-fx-background-color: #F2F2F2");
        }
    }
    @FXML
    protected void switchToHome(ActionEvent event) {
        color(true);
        if(labUser.getText().equals("") || labPassword.getText().equals(""))
        {
            color(false);
        }else {
            LoginBean bean=new LoginBean(labUser.getText());
            String log = bean.getLog(labPassword.getText());
            if(log==null){
                color(false);
                return ;
            }
            switch(log){
                case "usr":{
                    controller.switchTo("homepage/interf1.fxml",event,"Home");
                    break;
                }
                case "psy":{
                    controller.switchTo("homepagePsychologist/interf1.fxml",event,"Home");
                    break;
                }
                default:{
                    color(false);
                }

            }
        }
    }}
