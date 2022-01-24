package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SearchControllerInterf2 extends SearchControllerInterf1 {
    @FXML
    AnchorPane Result_Visit;
    String [] uids;
    public SearchControllerInterf2(){
        super();
        uids=new String[6];
    }
    public void initialize(){
        super.initialize();
        visit();
    }
    public void goResult(ActionEvent event){
        try {
            Result_Visit.getChildren().removeAll(Result_Visit.getChildren());
            Result_Visit.getChildren().add((Node) FXMLLoader.load(getClass().getResource("ResultSearch/interf2.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void visit (){
        try {
            Result_Visit.getChildren().removeAll(Result_Visit.getChildren());
            Result_Visit.getChildren().add((Node) FXMLLoader.load(getClass().getResource("homepageOthers/interf2.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
