package progettoispw.letmeknow;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import progettoispw.letmeknow.controller.ConnectionDBMS;

import java.io.IOException;
import java.util.Optional;

public class Page {
    protected static Stage stage1;
    protected static Scene scene1;
    protected static String title1;
    private boolean check=true;
    private static final String INTERF1="interf1";
    private static final String INTERF2="interf2";
    private static final String FXML=".fxml";
    static void prevBack(ActionEvent event){
        stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene1 = ((Node) event.getSource()).getScene();
        title1= stage1.getTitle();
    }
    static String check(String name,Stage stage){
        int index;
        if(stage.getWidth()>500 && name.indexOf(INTERF1)>-1){
            index= name.indexOf(INTERF1);
            name=name.substring(0,index);
            name+="" + INTERF2+FXML;
        }
        else if(stage.getWidth()<500 && name.indexOf(INTERF2)>-1){
            index= name.indexOf(INTERF2);
            name=name.substring(0,index);
            name+=INTERF1+FXML;
            stage.setMaxWidth(414);
            stage.setMinHeight(736);
        }
        return name;
    }
    public void switchTo(String name, ActionEvent event, String title) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if(check)name=check(name,stage);
            prevBack(event);
            Parent root = FXMLLoader.load(getClass().getResource(name));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Exceptions.exceptionPageOccurred();
        }
    }
    public void backTo(){
        stage1.setScene(scene1);
        stage1.setTitle(title1);
        stage1.show();
    }
    public void setSize(String name,ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        int index;
        index= name.indexOf(INTERF2);
        if(index==-1) index= name.indexOf(INTERF1);
        if(stage.getWidth()>500) {
            name=name.substring(0,index);
            name+="" + INTERF1+FXML;
        }
        else{
            name=name.substring(0,index);
            name+="" + INTERF2+FXML;
        }
        check=false;
        switchTo(name,event,stage.getTitle());
    }
}