package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import progettoispw.letmeknow.bean.BeanResultSearch;

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
    public void setOpacity(Button button ){button.setStyle("-fx-opacity: 1.0");}
    public void setHome() {
        setOpacity(home);
    }
    public void setSearch() {
        setOpacity(search);
    }
    public void setSettings() {setOpacity(settings);}
    public void setPersonalForm() {setOpacity(form);}
}
