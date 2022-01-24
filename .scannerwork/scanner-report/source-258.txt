package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface Interf2ButtonBar {
    PageMenu controller=new PageMenu();
    @FXML
    static void goToHome(ActionEvent event){
        controller.switchToHome(event);
    }
    @FXML
    static void goToChat(ActionEvent event){
        controller.switchToChat(event);
    }












}
