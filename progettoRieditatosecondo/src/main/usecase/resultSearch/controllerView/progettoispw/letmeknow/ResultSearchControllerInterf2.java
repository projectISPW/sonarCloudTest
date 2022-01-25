package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import progettoispw.letmeknow.bean.BeanResultSearch;

import java.io.IOException;

public class ResultSearchControllerInterf2{
    @FXML
    private Group group1;
    @FXML
    private Group group2;
    @FXML
    private Group group3;
    @FXML
    private Group group4;
    @FXML
    Group group5;
    @FXML
    Group group6;
    @FXML
    AnchorPane Result_Visit;
    String [] uids;
    public ResultSearchControllerInterf2(){
        uids=new String[6];
    }
    public void initialize(){
        outputVal();
    }
    public void visit(ActionEvent event) {
        BeanResultSearch  visitBean=new BeanResultSearch();
        Button button=(Button) event.getTarget();
        if(button.getOpacity()<1)return ;
        switch(button.getId()){
            case "home1" :visitBean.touched(uids[0]);break;
            case "home2" :visitBean.touched(uids[1]);break;
            case "home3" :visitBean.touched(uids[2]);break;
            case "home4" :visitBean.touched(uids[3]);break;
            case "home5" :visitBean.touched(uids[4]);break;
            case "home6" :visitBean.touched(uids[5]);break;
            default:{
                event.consume();
            }
        }
        try {
            Result_Visit.getChildren().removeAll(Result_Visit.getChildren());
            Result_Visit.getChildren().add((Node) FXMLLoader.load(getClass().getResource("homepageOthers/interf2.fxml")));
        } catch (IOException e) {
            event.consume();
        }
    }
    public void touchChat(ActionEvent actionEvent) {
        HomepagecontrollerInterf2 homepage=new HomepagecontrollerInterf2(uids);
        homepage.touchChat(actionEvent);
    }
    public void outputVal() {
        ResultSearchControllerInterf1 rscInterf1=new ResultSearchControllerInterf1();
        String [] inner =new String [6];
        uids=rscInterf1.ouputVal_prev(new Group[]{group1,group2,group3,group4,group5,group6},6);
    }
}
