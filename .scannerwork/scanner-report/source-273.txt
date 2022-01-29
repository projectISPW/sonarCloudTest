package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomepageControllerInterf2 extends HomepagecontrollerInterf1{
    @FXML
    AnchorPane homepage_edit;
    @FXML
    protected void editProfile(ActionEvent event){
        try {
            homepage_edit.getChildren().removeAll(homepage_edit.getChildren());
            homepage_edit.getChildren().add((Node) FXMLLoader.load(getClass().getResource("homepageEdit/homepageEdit.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
