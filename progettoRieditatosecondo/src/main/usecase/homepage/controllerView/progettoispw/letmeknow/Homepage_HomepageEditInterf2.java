package progettoispw.letmeknow;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.BeanResultSearch;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.UseridBean;

import java.io.IOException;


public class Homepage_HomepageEditInterf2 {
    @FXML
    AnchorPane homepage_edit;
    @FXML
    AnchorPane notice_settings;
    @FXML
    AnchorPane buttonBar;

    public void initialize(){
        load();
    }
    public void load () {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("buttonBarInterf2.fxml"));
            buttonBar.getChildren().add((Node)loader.load());
            ButtonBarInterf2 barController=loader.getController();
            barController.setHome();
            homepage_edit.getChildren().removeAll(homepage_edit.getChildren());
            homepage_edit.getChildren().add((Node) FXMLLoader.load(getClass().getResource("homepage/homepage.fxml")));
            notice_settings.getChildren().removeAll(notice_settings.getChildren());
            notice_settings.getChildren().add((Node) FXMLLoader.load(getClass().getResource("homepage/noticeBoard.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
