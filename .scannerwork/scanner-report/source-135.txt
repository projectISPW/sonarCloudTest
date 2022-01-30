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
import progettoispw.letmeknow.controller.ConnectionDBMS;
import java.io.IOException;
import java.util.Optional;

public class MainApplication extends Application {
    private enum ScreenSize{
        LAPTOP,SMARTPHONE
    }
    private static ScreenSize size;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root;
        if(size==ScreenSize.LAPTOP){
            stage.setFullScreen(true);
            root=FXMLLoader.load(getClass().getResource("login/interf2.fxml"));
        }
        else{
            stage.setMaxWidth(414);
            stage.setMinHeight(736);
            root=FXMLLoader.load(getClass().getResource("login/interf1.fxml"));
        }
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.setResizable(false);
        Image icon= new Image(getClass().getResourceAsStream("photo/brain.jpg"));
        stage.getIcons().add(icon);
        //Alert in fase di uscita dall'applicazione
        stage.setOnCloseRequest(input->new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit Confirmation");
                alert.setHeaderText("Are you sure to exit program?");
                alert.setContentText("If you want to exit you'll be logged out from application.");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.isPresent() && result.get() == ButtonType.OK){
                    ConnectionDBMS conn=new ConnectionDBMS();
                    conn.closeCONN();
                    Platform.exit();
                    System.exit(0);
                }
                else{
                    windowEvent.consume();
                }
            }
        });
        stage.show();
    }
    public static void main(String[] args) {
        size=ScreenSize.LAPTOP;
        launch();
    }
}