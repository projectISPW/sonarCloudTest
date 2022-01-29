package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import progettoispw.letmeknow.bean.VisitBean;

import java.io.IOException;

public class SearchControllerInterf2 extends SearchControllerInterf1 {
    @FXML
    AnchorPane Result_Visit;
    @FXML
    AnchorPane buttonBar;
    String [] uids;
    public SearchControllerInterf2(){
        super();
        uids=new String[6];
    }
    public void initialize(){
        super.initialize();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buttonBarInterf2.fxml"));
        try {
            buttonBar.getChildren().add((Node)loader.load());
            ButtonBarInterf2 barController=loader.getController();
            barController.setSearch();
            VisitBean beanVisit =new VisitBean();
            if(beanVisit.getUserId()!=null)visit();
        } catch (IOException e) {
            buttonBar.getChildren().removeAll(buttonBar.getChildren());
        }
    }
    public void goResult(ActionEvent event){
        try {
            Result_Visit.getChildren().removeAll(Result_Visit.getChildren());
            Result_Visit.getChildren().add((Node) FXMLLoader.load(getClass().getResource("ResultSearch/interf2.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void visit (){
        try {
            Result_Visit.getChildren().removeAll(Result_Visit.getChildren());
            Result_Visit.getChildren().add((Node) FXMLLoader.load(getClass().getResource("homepageOthers/interf2.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
