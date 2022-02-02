package progettoispw.letmeknow;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import progettoispw.letmeknow.bean.SettingsBean;


import java.net.URL;
import java.util.ResourceBundle;

public class SettingsControllerInterf1 implements Initializable {
    private PageMenu controller;
    private SettingsBean bean;
    private static final String DEFAULTBORDER="-fx-border-color: rgba(55, 125, 255,0.7)";
    private static final String REDBORDER="-fx-border-color:red";
    @FXML
    PasswordField pswd;
    @FXML
    PasswordField confirmpswd;
    @FXML
    TextField email;
    @FXML
    TextArea feedback;
    @FXML
    protected ComboBox<String> comb;
    private boolean bool;
    public SettingsControllerInterf1(){
        bean=new SettingsBean();
        controller=new PageMenu();
        bool=false;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        comb.setItems(FXCollections.observableArrayList("Italiano", "Inglese"));
    }
    @FXML
    protected void goBack() {
        controller.backTo();
    }
    @FXML
    protected void goEditProf(ActionEvent event){
        controller.switchTo("homepageEdit/interf1.fxml", event,"Edit");
    }
    @FXML
    protected void goToHome(ActionEvent event)  {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToChat(ActionEvent event) {
        controller.switchToISC(event);
    }
    @FXML
    protected void setPswd()  {
        pswd.setStyle(DEFAULTBORDER);
        confirmpswd.setStyle(DEFAULTBORDER);
        bool=bean.setPassword(pswd.getText(),pswd.getText());
        if(!bool){
            pswd.setStyle(REDBORDER);
            confirmpswd.setStyle(REDBORDER);
        }else{
            pswd.setText("");
            confirmpswd.setText("");
        }
    }
    @FXML
    protected void signOut(ActionEvent event){
        bean.closeConnection();
        controller.switchTo("login/interf1.fxml",event,"login");
    }
    @FXML
    protected void setMail (){
        email.setStyle(DEFAULTBORDER);
        bool=bean.setEmail(email.getText());
        if(!bool){
            email.setStyle(REDBORDER);
        }else{
            email.setText("");
        }
    }
    @FXML
    protected void setFeed(){
        feedback.setStyle("-fx-border-color: white");
        bool=bean.setFeed(feedback.getText());
        if(!bool){
            feedback.setStyle(REDBORDER);
        }else{
            feedback.setText("");
        }
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void setSize(ActionEvent event ){
        controller.setSize("settings/interf1.fxml",event);
    }

}

