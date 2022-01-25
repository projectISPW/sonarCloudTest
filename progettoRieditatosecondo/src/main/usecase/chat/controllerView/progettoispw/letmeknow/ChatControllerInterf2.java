package progettoispw.letmeknow;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import progettoispw.letmeknow.bean.ChatBean;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.BeanResultSearch;

import java.io.IOException;
import java.util.Date;

public class ChatControllerInterf2 extends ChatControllerInterf1{
    @FXML
    AnchorPane listUtenti;
    @FXML
    TextField searchBar;
    ISCBean iscBean;
    private String userid;
    public ChatControllerInterf2(){
        super();
        iscBean=new ISCBean();
        graphic=new CSS(false);
        userid=bean.getUid();
        timeline=new Timeline(new KeyFrame(Duration.millis(1000),this::recivemsgArr));
    }

    public void recivemsgArr(ActionEvent event){
        if(initializated) {
            recivemsgArr();
            addUser();
        }
    }
    @FXML
    protected void sendMsg() {
        super.sendMsg();
        addUser();
    }
    public void  initialize(){
        addUser();
        if(userid==null){
            /*chat vuota
            listUtenti;
            prendi il primo user che trovi


            */
        }
        super.initialize();
    }
    public String checkUsrId(String input){
        if(input.length()<=8){
            return input;
        }
        int indice=-1;
        indice=input.indexOf("||");
        String sub=input.substring(0,indice);
        if(sub.equals(userid)==false) {
            return sub;
        }
        return input.substring(indice+2);
    }
    private void goChat(ActionEvent event){
        Button button=(Button)event.getTarget();
        String who=button.getText();
        who=checkUsrId(who);
        iscBean.touched(who);
        controller.switchToChat(event);
    }
    public  void addUser(){
        listUtenti.getChildren().removeAll(listUtenti.getChildren());
        graphic.setHList();
        Button userButton;
        Label msgLabel;
        String [][] innerusers =iscBean.exitUid();
        String [] uid=innerusers[0];
        String [] msg=innerusers[1];
        for(int i=0;i< uid.length;i++){
            userButton=graphic.getButton(uid[i]);
            msgLabel=graphic.getLabel(msg[i]);
            userButton.setOnAction(this::goChat);
            listUtenti.getChildren().addAll(userButton,msgLabel);
            listUtenti.setPrefHeight(graphic.getHlist());
        }
    }
    @FXML
    public void searchMessage(){
        iscBean.search(searchBar.getText());
        addUser();
    }

}
