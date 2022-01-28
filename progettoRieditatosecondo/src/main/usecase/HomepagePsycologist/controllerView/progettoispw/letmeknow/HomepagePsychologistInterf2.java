package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import progettoispw.letmeknow.bean.HomepagePsychologistBean;

import java.io.IOException;

public class HomepagePsychologistInterf2 extends HomepagePsychologistInterf1{
    @FXML
    AnchorPane anchorSelected;
    @FXML
    public void select(ActionEvent event){
        try {
            Button button=(Button) event.getTarget();
            int val=0;
            switch(button.getId()){
                case "form1" :{
                    bean.setSelected(1);
                    val=1;
                    break;
                }
                case "form2" :{
                    bean.setSelected(2);
                    val=2;
                    break;
                }
                case "form3" :{
                    bean.setSelected(3);
                    val=3;
                    break;
                }
                default :{
                    event.consume();
                }
            }
            anchorSelected.getChildren().removeAll(anchorSelected.getChildren());
            anchorSelected.getChildren().add((Node) FXMLLoader.load(getClass().getResource("homepagePsychologist/formSelected"+val+".fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void goToSettings(ActionEvent event ){
        try {
            anchorSelected.getChildren().removeAll(anchorSelected.getChildren());
            anchorSelected.getChildren().add((Node) FXMLLoader.load(getClass().getResource("settingsPsychologist/interf2.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void increm() {
        anchorSelected.getChildren().removeAll(anchorSelected.getChildren());
        bean.incremMonth();
        initialize();
    }
    public void decrem() {
        anchorSelected.getChildren().removeAll(anchorSelected.getChildren());
        bean.decremMonth();
        initialize();
    }
}
