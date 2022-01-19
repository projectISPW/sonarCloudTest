package progettoispw.letmeknow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import progettoispw.letmeknow.bean.LoginBean;


import java.io.IOException;

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
    private String userID;
    private boolean clicked;
    public LoginControllerInterf1(){
        clicked=false;
    }
    @FXML
    protected void switchToSignup(ActionEvent event) {
        //controller.switchTo("signup.fxml",event,"Signup");
        controller.switchTo("signup/interf1.fxml",event,"Signup");
        //controller.goTo("signup",event);
    }
    @FXML
    protected void switchToRecoverPswd(ActionEvent event) {
        controller.switchTo("recoverpassword/interf1.fxml",event,"Recover password");
        //controller.switchTo("recover password",event);
    }
    @FXML
    protected void switchToSignUpPsych(ActionEvent event) {
        controller.switchTo("signupPsicologist/interf1.fxml",event,"Signup");
    }
    @FXML
    protected void showPSWD(){
        if(clicked==false){
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

    @FXML
    protected void switchToHome(ActionEvent event) throws IOException {
        if(labUser.getText().equals("") || labPassword.getText().equals(""))
        {
            //Alert Dialog Message per campi email e password vuoti
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Fields!");
            alert.setHeaderText("Empty Email / Password Field");
            alert.setContentText("Please, fill Email and Password Fields. They cannot be empty.");
            if(alert.showAndWait().get()==ButtonType.OK) {
                System.out.println("Prompt: Empty Fields Alert");
                event.consume();
            }
        }else {
            LoginBean bean=new LoginBean(labUser.getText(),labPassword.getText());
            String log = bean.exitValue();
            System.out.println(log);
            userID=labUser.getText();
            switch(log){
                case "usr":{
                    //HomepagecontrollerInterf1.userid=labUser.getText();
                    controller.switchTo("homepage/interf1.fxml",event,"Home");
                    return;
                }
                case "psy":{
                    controller.switchTo("homepagePsicologist/interf1.fxml",event,"Home");
                    System.out.println("fatto accesso da psicologo");
                }
            }
        }
    }}
