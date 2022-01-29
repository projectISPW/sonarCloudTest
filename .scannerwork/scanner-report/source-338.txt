package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import progettoispw.letmeknow.bean.BeanResultSearch;
import progettoispw.letmeknow.bean.SearchBean;

public class ButtonBarInterf2 {
    PageMenu controller= new PageMenu();
    @FXML
    Button home;
    @FXML
    Button chat;
    @FXML
    Button form;
    @FXML
    Button search;
    @FXML
    Button settings;
    public void initialize(){
        Button [] buttons=new Button[] {home,chat,form,search,settings};
        for(Button button:buttons)button.setStyle("-fx-opacity: 0.5");
    }
    public void goToChat(ActionEvent actionEvent) {
        controller.switchToChat(actionEvent);
    }
    public void goToHome(ActionEvent actionEvent) {
        BeanResultSearch bean=new BeanResultSearch();
        bean.reset();
        controller.switchToHome(actionEvent);
    }
    public void goToForm(ActionEvent actionEvent) {
        controller.switchToPersonalForm(actionEvent);
    }
    public void goToSettings(ActionEvent actionEvent) {
        controller.switchToSettings(actionEvent);
    }
    public void goToSearch(ActionEvent actionEvent) {
        controller.switchToSearch(actionEvent);
    }
    public void setHome() {
        this.home.setStyle("-fx-opacity: 1.0");
    }
    public void setSearch() {
        this.search.setStyle("-fx-opacity: 1.0");
    }
    public void setChat(){this.chat.setStyle("-fx-opacity: 1.0");}
    public void setSettings() {this.settings.setStyle("-fx-opacity: 1.0");}
    public void setPersonalForm() {this.form.setStyle("-fx-opacity: 1.0");}
}
