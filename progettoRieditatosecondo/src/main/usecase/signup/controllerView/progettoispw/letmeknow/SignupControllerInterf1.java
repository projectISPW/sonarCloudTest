package progettoispw.letmeknow;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import progettoispw.letmeknow.bean.GoToFormBean;
import progettoispw.letmeknow.bean.SignupBean;

import java.io.IOException;
import java.util.Vector;

public class SignupControllerInterf1 {
    private Page controller= new Page();
    @FXML
    TextField email,description,goal;
    @FXML
    PasswordField pswd,confirmpswd;
    @FXML
    Slider sl1,sl2,sl3;
    Vector<Slider>sl;
    @FXML
    Label lab1,lab2,lab3;
    Label[]labels;
    @FXML
    Label emailCheck,pswdCheck,desCheck,slCheck;
    private int indice;
    SignupBean bean;
    public SignupControllerInterf1(){
        bean=new SignupBean();
        sl=new Vector<>();
    }
    public void initialize() {
        sl.add(sl1);
        sl.add(sl2);
        sl.add(sl3);
        labels = new Label[]{lab1, lab2, lab3};
        indice = 0;
        for (Slider slider : sl) {
            slider.valueProperty().addListener((observableValue, number, t1) -> {
                indice = sl.indexOf(slider);
                labels[indice].setText("" + (int) slider.getValue());
                labels[indice].setOpacity(1);
            });
        }
    }
    @FXML
    protected void backToLogin() {
        controller.backTo();
    }
    private boolean check(Boolean bool,Label lab){
        if(bool==false)lab.setOpacity(1);
        return bool;
    }

    @FXML
    protected void save(ActionEvent event) {
        Boolean bool;
        String[] arr;
        int [] val;
        emailCheck.setOpacity(0);
        pswdCheck.setOpacity(0);
        desCheck.setOpacity(0);
        slCheck.setOpacity(0);
        bool=bean.checkEmail(email.getText(),true);
        if(check(bool,emailCheck)==false)return;
        bool=bean.checkPswd(pswd.getText(),confirmpswd.getText());
        if(check(bool,pswdCheck)==false)return;

        bool=bean.checkDescription(description.getText());
        System.out.println(bool);
        if(check(bool,desCheck)==false)return;

        arr= new String[]{lab1.getText(), lab2.getText(), lab3.getText()};
        val=bean.checkVal(arr);
        bool=true;
        if(val==null)bool=false;
        if(check(bool,slCheck)==false)return;
        bool=bean.signupUSR(pswd.getText(),email.getText(),val, description.getText(), goal.getText());
        if(bool)backToLogin();
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("keep attention ");
            alert.setHeaderText("Non siamo riusciti a prendere i tuoi dati per favore ritenta !");
            alert.setContentText("Please, fill Email and Password Fields. They cannot be empty.");
            if(alert.showAndWait().get()==ButtonType.OK) {
                System.out.println("Prompt: Empty Fields Alert");
                event.consume();
                return;
            }
        }
    }
}
