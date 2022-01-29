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


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsControllerInterf1 implements Initializable {
    private PageMenu controller;
    private SettingsBean bean;
    @FXML
    PasswordField pswd;
    @FXML
    PasswordField confirmpswd;
    @FXML
    TextField email;
    @FXML
    TextArea feedback;
    @FXML
    private ComboBox<String> comb;
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
    protected void goBack() throws IOException {
        controller.backTo();
    }
    @FXML
    protected void goEditProf(ActionEvent event){
        controller.switchTo("homepageEdit/interf1.fxml", event,"Edit");
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchToISC(event);
    }
    @FXML
    protected void setPswd()  {
        pswd.setStyle("-fx-border-color: rgba(55, 125, 255,0.7)");
        confirmpswd.setStyle("-fx-border-color: rgba(55, 125, 255,0.7)");
        bool=bean.setPassword(pswd.getText(),pswd.getText());
        if(!bool){
            pswd.setStyle("-fx-border-color: red");
            confirmpswd.setStyle("-fx-border-color: red");
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
        email.setStyle("-fx-border-color: rgba(55, 125, 255,0.7)");
        bool=bean.setEmail(email.getText());
        if(!bool){
            email.setStyle("-fx-border-color: red");
        }else{
            email.setText("");
        }
    }
    @FXML
    protected void setFeed(){
        feedback.setStyle("-fx-border-color: white");
        bool=bean.setFeed(feedback.getText());
        if(!bool){
            feedback.setStyle("-fx-border-color: red");
        }else{
            feedback.setText("");
        }
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }

}

