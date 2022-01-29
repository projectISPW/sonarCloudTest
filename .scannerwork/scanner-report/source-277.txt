package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import progettoispw.letmeknow.HomepageEditControllerInterf1;

import java.io.IOException;

public class HomepageEditControllerInterf2 extends HomepageEditControllerInterf1 {
    @FXML
    AnchorPane homepage_edit;
    @FXML
    protected void goToHome(ActionEvent event) {
        try {
            homepage_edit.getChildren().removeAll(homepage_edit.getChildren());
            homepage_edit.getChildren().add((Node) FXMLLoader.load(getClass().getResource("homepage/homepage.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void takeForm(ActionEvent event){
        controller.switchToPersonalForm(event);
    }
}
