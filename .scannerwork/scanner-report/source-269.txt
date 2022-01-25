package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface Interf1ButtonBar {
    PageMenu controller=new PageMenu();
    @FXML
    static void goToISC(ActionEvent event){
        controller.switchToISC(event);
    }
    @FXML
    static void goToPesonalForm(ActionEvent event){
        controller.switchToHome(event);
    }
    @FXML
    static void goToHome(ActionEvent event){controller.switchToHome(event);}

}
