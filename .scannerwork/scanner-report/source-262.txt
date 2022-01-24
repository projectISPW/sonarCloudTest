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
    private static final String UID_CONTENT ="#";
    private static final String MSG_WORKON ="...";
    private static final String DESCRIPTION ="About me:";
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
    int nVal;
    public HomepagecontrollerInterf2(){
        id=new UseridBean();
        userid= id.getUserId();
        nVal=3;
        iscBean=new ISCBean(3);
        visitBean=new BeanResultSearch(3);
        uids=new String[6];
    }
    public void initialize(){
        chatExtGroup=new Group[]{extGroup1,extGroup2,extGroup3};
        chatGroup=new Group []{group1,group2,group3};
        visitGroup=new Group[]{group4,group5,group6};
        outputValChat();
        outputValVisited();
        super.initialize();
    }
    public void setGroups(Group [] chatExtGroupInput, Group []chatGroupInp){
        chatExtGroup=chatExtGroupInput;
        chatGroup=chatGroupInp;
    }
    private Group [] chatExtGroup;
    private Group []chatGroup;

    public  void outputValChat(){
        for(int i=0;i<nVal;i++){
            chatExtGroup[i].setOpacity(1);
        }
        String [][] innerusers =iscBean.exitUid();
        String [] strUid=innerusers[0];
        String [] strLst=innerusers[1];
        for(int i=0;i<nVal;i++){
            if(strUid[i]==null || strLst[i]==null){
                chatExtGroup[i].setOpacity(0);
            }
            ObservableList<Node> inner= chatGroup[i].getChildren();
            for(Node elem:inner){
                Text text=(Text)elem;
                uids[i]=strUid[i];
                if(text.getText().contains(UID_CONTENT)){
                    text.setText(UID_CONTENT +strUid[i]);
                }
                else if(text.getText().contains(MSG_WORKON))text.setText(strLst[i]);
            }
        }
    }
    Group [] visitGroup;
    public void setVisitGroup(Group [] inp){
        visitGroup=inp;
    }
    public void outputValVisited(){
        for(int i=0;i<nVal;i++){
            visitGroup[i].setOpacity(1);
        }
        String [][] users=visitBean.exitDes();
        String[] strDes= users[2];
        String[] strGoal=users[1];
        String[] strUid=users[0];
        for(int i=0;i<nVal;i++){
            ObservableList<Node> externList= visitGroup[i].getChildren();
            Group group =(Group)externList.get(2);
            ObservableList<Node>inner=group.getChildren();
            if(strUid[i]!=null){
                uids[3+i]=strUid[i];
            for(Node elem:inner){
                Text text=(Text)elem;
                uids[3+i]=strUid[i];
                if(text.getText().contains(UID_CONTENT)){
                    text.setText(UID_CONTENT+strUid[i]);
                }
                else if(text.getText().contains(MSG_WORKON))text.setText("Working on:"+strGoal[i]);
                else if(text.getText().contains(DESCRIPTION))text.setText(DESCRIPTION+strDes[i]);
            }
        }
        else {
            visitGroup[i].setOpacity(0);
        }}
    }
    @FXML
    public void touchChat(ActionEvent event){
        Button button=(Button) event.getTarget();
        if(button.getOpacity()<1)return ;
        switch(button.getId()){
            case "chat1" :iscBean.touched(uids[0]);break;
            case "chat2" :iscBean.touched(uids[1]);break;
            case "chat3" :iscBean.touched(uids[2]);break;
            case "chat4" :iscBean.touched(uids[3]);break;
            case "chat5" :iscBean.touched(uids[4]);break;
            case "chat6" :iscBean.touched(uids[5]);break;
            default :{
               event.consume();
            }
        }
        controller.switchToChat2(event);
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
        controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
    }
}
