package progettoispw.letmeknow;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.BeanResultSearch;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.UseridBean;


public class HomepagecontrollerInterf2 extends HomepagecontrollerInterf1 {
    private ISCBean iscBean;
    private BeanResultSearch visitBean;
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
    public HomepagecontrollerInterf2(){
        uids=new String[6];
        iscBean=new ISCBean();
        visitBean=new BeanResultSearch();
    }
    public HomepagecontrollerInterf2(String []input){
        uids=input;
        iscBean=new ISCBean();
        visitBean=new BeanResultSearch();
    }
    public void initialize(){
        outputValChat();
        outputValVisited();
        super.initialize();
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
        Button button=(Button) event.getTarget();
        if(button.getOpacity()<1)return ;
        switch(button.getId()){
            case "chat1" :{
                iscBean.touched(uids[0]);
                System.out.println(uids[0]);
                break;
            }
            case "chat2" :iscBean.touched(uids[1]);break;
            case "chat3" :iscBean.touched(uids[2]);break;
            case "chat4" :iscBean.touched(uids[3]);break;
            case "chat5" :iscBean.touched(uids[4]);break;
            case "chat6" :iscBean.touched(uids[5]);break;
            default :{
               event.consume();
            }
        }
        controller.switchToChat(event);
    }
    @FXML
    public void visit(ActionEvent event){
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
        controller.switchTo("search/interf2.fxml",event,"Visit");
    }
    @FXML
    public void goToSearch(ActionEvent event ){
        controller.switchToSearch(event);
    }
    @FXML
    public void goToChat(ActionEvent event){
        iscBean.touched(uids[0]);
        controller.switchToChat(event);
    }
}
