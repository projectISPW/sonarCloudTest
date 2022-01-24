package progettoispw.letmeknow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;


public class HomepageEditControllerInterf2 extends HomepageEditControllerInterf1 {
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
    public HomepageEditControllerInterf2(){
        homepage=new HomepagecontrollerInterf2();
    }
    public void initialize(){
        homepage.setGroups(new Group[]{extGroup1,extGroup2,extGroup3},new Group []{group1,group2,group3});
        homepage.setVisitGroup(new Group[]{group4,group5,group6});
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
