package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import progettoispw.letmeknow.bean.FormToTakeStatusBean;

import java.io.IOException;


public class FormCollectionResultsInterf2 extends FormCollectionResultsInterf1 {
    @FXML
    AnchorPane anchorSelected;
    @FXML
    AnchorPane buttonBar;
    @Override
    public void initialize(){
        try {
            super.initialize();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("buttonBarInterf2.fxml"));
            buttonBar.getChildren().add((Node)loader.load());
            ButtonBarInterf2 barController=loader.getController();
            barController.setPersonalForm();
            takeForm();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected  void which(int i,ActionEvent event){
        try {
            bean.setTouched(i);
            anchorSelected.getChildren().removeAll(anchorSelected.getChildren());
            anchorSelected.getChildren().add((Node) FXMLLoader.load(getClass().getResource("formCollectionResults/formSelected"+i+".fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void takeForm(){
        try {
            bean.takeForm();
            FormToTakeStatusBean innerBean=new FormToTakeStatusBean();
            int val= innerBean.getFormId();
            anchorSelected.getChildren().removeAll(anchorSelected.getChildren());
            anchorSelected.getChildren().add((Node) FXMLLoader.load(getClass().getResource("formCollectionResults/formSelected"+val+".fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void takeForm(ActionEvent event){
        takeForm();
    }
}
