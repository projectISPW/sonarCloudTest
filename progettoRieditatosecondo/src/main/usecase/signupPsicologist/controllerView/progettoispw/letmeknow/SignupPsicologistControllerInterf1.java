package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import progettoispw.letmeknow.bean.SignupBean;

public class SignupPsicologistControllerInterf1 {
    SignupBean bean;
    Page controller=new Page();
    @FXML
    TextField email;
    @FXML
    PasswordField pswd,confirmpswd;
    @FXML
    Label emailCheck,pswdCheck;
    public SignupPsicologistControllerInterf1() {
        bean=new SignupBean();
    }
    public void initialize(){

    }
    private boolean check(Boolean bool,Label lab){
        if(bool==false)lab.setOpacity(1);
        return bool;
    }
    @FXML
    protected void backToLogin() {
        controller.backTo();
    }
    public void save (ActionEvent event) {
        Boolean bool;
        emailCheck.setOpacity(0);
        pswdCheck.setOpacity(0);
        bool = bean.checkEmail(email.getText(), true);
        if (check(bool, emailCheck) == false) return;
        bool = bean.checkPswd(pswd.getText(), confirmpswd.getText());
        if (check(bool, pswdCheck) == false) return;
        bool = bean.signupPSY(pswd.getText(), email.getText());
        if (bool) backToLogin();
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("keep attention ");
            alert.setHeaderText("Non siamo riusciti a prendere i tuoi dati per favore ritenta !");
            alert.setContentText("Please, fill Email and Password Fields. They cannot be empty.");
            if (alert.showAndWait().get() == ButtonType.OK) {
                System.out.println("Prompt: Empty Fields Alert");
                event.consume();
                return;
            }
        }
    }
}
