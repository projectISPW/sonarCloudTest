package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Page {
    protected Scene scene;
    protected Stage stage;
    static Stage stage1;
    static Scene scene1;
    static String title1;
    protected Parent root;
    static void back(ActionEvent event){
            stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene1 = ((Node) event.getSource()).getScene();
            title1= stage1.getTitle();
    }

    public void switchTo(String name, ActionEvent event, String title) {
        int index;
        try {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println("titolo dello stage"+stage.getTitle());
            back(event);
            if(stage.getWidth()>500 && name.indexOf("interf1")>-1){
                index= name.indexOf("interf1");
                name=name.substring(0,index);
                name+="interf2.fxml";
            }
            if(stage.getWidth()<500 && name.indexOf("interf2")>-1){
                index= name.indexOf("interf2");
                name=name.substring(0,index);
                name+="interf1.fxml";
            }
            System.out.println(name+","+stage.getWidth());
            root = FXMLLoader.load(getClass().getResource(name));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void backTo(){
        stage=stage1;
        scene=scene1;
        stage.setScene(scene);
        stage.setTitle(title1);
        stage.show();
    }
}