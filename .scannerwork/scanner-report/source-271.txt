package progettoispw.letmeknow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import progettoispw.letmeknow.bean.BeanResultSearch;
import progettoispw.letmeknow.bean.ChatBean;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.SearchBean;

import java.net.URL;
import java.util.ResourceBundle;

public class AdviseBoarcControllerInterf2 {
    @FXML
    PieChart graphVisit;
    @FXML
    Group group1;
    @FXML
    Group group2;
    @FXML
    Group group3;
    @FXML
    Group extGroup1;
    @FXML
    Group extGroup2;
    @FXML
    Group extGroup3;
    @FXML
    Group group4;
    @FXML
    Group group5;
    @FXML
    Group group6;
    String [] uids;
    public AdviseBoarcControllerInterf2(){
        uids =new String[6];
    }

    public void initialize(){
        outputValChat();
        outputValVisited();
        BeanResultSearch bean=new BeanResultSearch();
        int [] val=bean.getnval();
        System.out.println("num visit by me "+val[0]+"vs "+val[1]);
        ObservableList<PieChart.Data>graphData=
                FXCollections.observableArrayList(
                        new PieChart.Data("global visit",val[0]),
                        new PieChart.Data("recived visit",val[1])
                );
        graphVisit.setData(graphData);
    }
    public  void outputValChat(){
        InitialSearchAndChatControllerInterf1 iscInterf1=new InitialSearchAndChatControllerInterf1();
        String [] inner=iscInterf1.prev_outputValChat(new Group[]{extGroup1,extGroup2,extGroup3},new Group[]{group1,group2,group3},3);
        for(int i=0;i<3;i++)uids[i]=inner[i];
    }
    public void outputValVisited(){
        ResultSearchControllerInterf1 rscInterf1=new ResultSearchControllerInterf1();
        String [] inner=rscInterf1.ouputVal_prev(new Group[]{group4,group5,group6},3);
        for(int i=0;i<3;i++)uids[i+3]=inner[i];
    }
    @FXML
    public void touchChat(ActionEvent event){
        InitialSearchAndChatControllerInterf1 isc=new InitialSearchAndChatControllerInterf1(uids);
        isc.touchChat(event);
    }
    @FXML
    public void visit(ActionEvent event){
        PageMenu controller=new PageMenu();
        ResultSearchControllerInterf2 rscIntf2=new ResultSearchControllerInterf2(uids);
        rscIntf2.visit(event);
        controller.switchToSearch(event);
    }
}
