package progettoispw.letmeknow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import progettoispw.letmeknow.bean.SignupBean;

import java.util.Optional;


public class SignupControllerInterf1 {
    private Page controller= new Page();
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
        controller.backTo();
    }
    private boolean check(boolean bool,Label lab){
        if(!bool)lab.setOpacity(1);
        return bool;
    }
    private void reset(){
        emailCheck.setOpacity(0);
        pswdCheck.setOpacity(0);
        desCheck.setOpacity(0);
        slCheck.setOpacity(0);
    }
    @FXML
    protected void save(ActionEvent event) {
        boolean bool;
        String[] arr;
        int [] val;
        reset();
        bool=bean.checkEmail(email.getText(),true);
        if(!check(bool,emailCheck))return;
        bool=bean.checkPswd(pswd.getText(),confirmpswd.getText());
        if(!check(bool,pswdCheck))return;

        bool=bean.checkDescription(description.getText());
        if(!check(bool,desCheck))return;

        arr= new String[]{lab1.getText(), lab2.getText(), lab3.getText()};
        val=bean.checkVal(arr);
        bool=true;
        if(val==null)bool=false;
        if(!check(bool,slCheck))return;
        bool=bean.signupUSR(pswd.getText(),email.getText(),val, description.getText(), goal.getText());
        if(bool) goToLogin();
        else{
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
