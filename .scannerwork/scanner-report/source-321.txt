package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import progettoispw.letmeknow.bean.SignupBean;

import java.util.Optional;

public class SignupPsychologistControllerInterf1 {
    SignupBean bean;
    @FXML
    TextField email;
    @FXML
    PasswordField pswd;
    @FXML
    PasswordField confirmpswd;
    @FXML
    Label emailCheck;
    @FXML
    Label pswdCheck;
    public SignupPsychologistControllerInterf1() {
        bean=new SignupBean();
    }
    public void reset(){
        pswdCheck.setOpacity(0);
        emailCheck.setOpacity(0);
    }
    public void initialize(){
        reset();
    }
    private boolean check(boolean bool,Label lab){
        if(!bool)lab.setOpacity(1);
        return bool;
    }
    @FXML
    protected void goToLogin() {
            Page controller=new Page();
            controller.backTo();
        }
    public void save (ActionEvent event) {
        boolean bool;
        reset();
        bool = bean.checkEmail(email.getText(), true);
        if (!check(bool, emailCheck)) return;
        bool = bean.checkPswd(pswd.getText(), confirmpswd.getText());
        if (!check(bool, pswdCheck)) return;
        bool = bean.signupPSY(pswd.getText(), email.getText());
        if (bool) goToLogin();
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("keep attention ");
            alert.setHeaderText("We weren't be able to retrieve your data, please try  again!");
            alert.setContentText("Please, fill Email and Password Fields. They cannot be empty.");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                event.consume();
            }
            else{
                goToLogin();
            }
        }
    }
}
