package progettoispw.letmeknow;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import progettoispw.letmeknow.controller.ConnectionDBMS;

import java.io.IOException;
import java.util.Optional;

public class Page {
    protected static Stage stage1;
    protected static Scene scene1;
    protected static String title1;
    static void prevBack(ActionEvent event){
        stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene1 = ((Node) event.getSource()).getScene();
        title1= stage1.getTitle();
    }
    static String check(String name,Stage stage){
        int index;
        if(stage.getWidth()>500 && name.indexOf("interf1")>-1){
            index= name.indexOf("interf1");
            name=name.substring(0,index);
            name+="" + "interf2.fxml";
        }
        else if(stage.getWidth()<500 && name.indexOf("interf2")>-1){
            index= name.indexOf("interf2");
            name=name.substring(0,index);
            name+="interf1.fxml";
            stage.setMaxWidth(414);
            stage.setMinHeight(736);
        }
        return name;
    }
    public void switchTo(String name, ActionEvent event, String title) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            name=check(name,stage);
            prevBack(event);
            Parent root = FXMLLoader.load(getClass().getResource(name));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Invalid resources ");
            alert.setHeaderText("we found found some trouble during the execution of the program");
            alert.setContentText("go to settings and report the problem");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                ConnectionDBMS conn =new ConnectionDBMS();
                conn.closeCONN();
                System.exit(0);
                Platform.exit();
            }
            Platform.exit();
        }
    }
    public void backTo(){
        stage1.setScene(scene1);
        stage1.setTitle(title1);
        stage1.show();
    }
}