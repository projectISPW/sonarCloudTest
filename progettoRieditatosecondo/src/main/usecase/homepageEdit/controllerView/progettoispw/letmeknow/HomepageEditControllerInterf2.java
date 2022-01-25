package progettoispw.letmeknow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;


public class HomepageEditControllerInterf2 extends HomepageEditControllerInterf1 {
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
    public HomepageEditControllerInterf2(){
        uids=new String[6];
    }
    public void initialize(){
        outputValChat();
        outputValVisited();
        super.initialize();
    }
    public  void outputValChat(){
        InitialSearchAndChatControllerInterf1 iscInterf1=new InitialSearchAndChatControllerInterf1();
        String [] inner=iscInterf1.prev_outputValChat(new Group[]{extGroup1,extGroup2,extGroup3},new Group[]{group1,group2,group3},3);
        for(int i=0;i<3;i++)uids[3]=inner[i];
    }
    public void outputValVisited(){
        ResultSearchControllerInterf1 rscInterf1=new ResultSearchControllerInterf1();
        String [] inner=rscInterf1.ouputVal_prev(new Group[]{group4,group5,group6},3);
        for(int i=0;i<3;i++)uids[i+3]=inner[i];
    }
    @FXML
    private void touchChat(ActionEvent event){
        HomepagecontrollerInterf2 homepage =new HomepagecontrollerInterf2(uids);
        homepage.touchChat(event);
    }
    @FXML
    private void visit(ActionEvent event){
        HomepagecontrollerInterf2 homepage =new HomepagecontrollerInterf2(uids);
        homepage.visit(event);
    }

}
