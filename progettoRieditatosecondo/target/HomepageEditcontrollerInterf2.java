package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;


public class HomepageEditcontrollerInterf2 extends HomepageEditControllerInterf1 {
    @FXML
    Group group1;
    @FXML
    Group group2;
    @FXML
    Group group3;
    @FXML
    Group extGroup1;
    @FXML
    Group extGroup2;
    @FXML
    Group extGroup3;
    @FXML
    Group group4;
    @FXML
    Group group5;
    @FXML
    Group group6;
    HomepagecontrollerInterf2 homepage;
    HomepageEditcontrollerInterf2(){
        homepage=new HomepagecontrollerInterf2();
    }
    public void initialize(){
        homepage.outputValChat();
        homepage.outputValVisited();
        super.initialize();
    }
    @FXML
    private void touchChat(ActionEvent event){
        homepage.touchChat(event);
    }
    @FXML
    private void visit(ActionEvent event){
        homepage.visit(event);
    }


}
