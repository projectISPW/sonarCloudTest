package progettoispw.letmeknow;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import progettoispw.letmeknow.bean.FormToTakeStatusBean;

import java.io.IOException;

public class FormInterf2 {
    @FXML
    private AnchorPane status;
    @FXML
    ScrollPane scrollAnswers;
    @FXML
    protected Slider sl1;
    @FXML
    protected Slider sl2;
    @FXML
    protected Slider sl3;
    @FXML
    protected Slider sl4;
    @FXML
    protected Slider sl5;
    @FXML
    protected Slider sl6;
    @FXML
    protected Label lb1;
    @FXML
    protected Label lb2;
    @FXML
    protected Label lb3;
    @FXML
    protected Label lb4;
    @FXML
    protected Label lb5;
    @FXML
    protected Label lb6;
    private int formid;
    private FormToTakeStatusBean bean;
    private TakeFormControllerInterf1 takeForm;
    private Button save;
    public FormInterf2(){
        bean=new FormToTakeStatusBean();
        formid=bean.getFormId();
    }
    public void initialize(){
        System.out.println("i am here with"+formid+"touched");
        takeForm=new TakeFormControllerInterf1(new Slider[]{sl1,sl2,sl3,sl4,sl5,sl6},new Label []{lb1,lb2,lb3,lb4,lb5,lb6});
        takeForm.setValues();
        setSection();
    }
    public void save(ActionEvent event){
        takeForm.save1();
        initialize();
    }
    public void setSection(){
        try {
            status.getChildren().removeAll(status.getChildren());
            if(takeForm.getComplete()==6){
            status.getChildren().add((Node) FXMLLoader.load(getClass().getResource("formCollectionResults/resultFormSectionInterf2.fxml")));
            }
            else{
                status.getChildren().add((Node) FXMLLoader.load(getClass().getResource("formCollectionResults/takeFormSectionInterf2.fxml")));
                ObservableList<Node> externList= status.getChildren();
                AnchorPane pane=(AnchorPane) externList.get(0);
                externList= pane.getChildren();
                save=(Button)externList.get(3);
                save.setOnAction(this::save);
            }
        }
        catch (IOException e) {
                e.printStackTrace();
            }
        }
}


