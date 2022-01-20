package progettoispw.letmeknow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import progettoispw.letmeknow.controller.ConnectionDB;
import progettoispw.letmeknow.controller.ConnectionDBMS;
import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.form.ResultForm;
import progettoispw.letmeknow.controller.search.Search;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("login/interf1.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        //stage.setResizable(false);
        //stage.setFullScreen(true);
        Image icon= new Image(getClass().getResourceAsStream("photo/brain.jpg"));
        stage.getIcons().add(icon);
        //Alert in fase di uscita dall'applicazione
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit Confirmation");
                alert.setHeaderText("Are you sure to exit program?");
                alert.setContentText("If you want to exit you'll be logged out from application.");
                if(alert.showAndWait().get() == ButtonType.OK){
                    //Log Out Account and Exit Program
                    // ...
                    ConnectionDBMS conn=new ConnectionDBMS();
                    conn.closeCONN();
                    System.out.println("Prompt: On Log Out phase");
                    Platform.exit();
                    System.exit(0);
                }else{
                    System.out.println("Prompt: On Cancel Confirmation Alert. Consume Event");
                    windowEvent.consume();
                }
            }
        });
        stage.show();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
         launch();
    }
}