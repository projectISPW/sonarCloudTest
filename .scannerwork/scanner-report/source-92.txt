package progettoispw.letmeknow;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;
import javafx.util.Duration;
import progettoispw.letmeknow.bean.ChatBean;
import progettoispw.letmeknow.bean.BeanResultSearch;


import javafx.animation.Timeline;


public class ChatControllerInterf1 {
    @FXML
    private AnchorPane messaggi;
    @FXML
    private TextArea inputmsg;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    protected Text withName;
    protected  boolean initializated;
    protected  PageMenu controller;
    protected ChatBean bean;
    protected  String [] message;
    protected  CSS graphic;
    protected Timeline timeline;
    public ChatControllerInterf1() {
        bean=new ChatBean();
        graphic=new CSS(true);
        initializated=false;
        controller=new PageMenu();
        timeline=new Timeline(new KeyFrame(Duration.millis(5000),this::action));
        timeline.setCycleCount(Animation.INDEFINITE);//never stop
    }
    @FXML
    protected void sendMsg() {
        inputmsg.setText(bean.newMsg(inputmsg.getText()));
        recivemsgArr();
    }
    private  void action(ActionEvent event ){
        if(initializated) {
            recivemsgArr();
        }
    }
    public void  recivemsgArr() {
        bean.getChat();
        message = bean.getMSG();
        Label textmsg;
        for (int i = 0; i < message.length; i += 2) {
            graphic.setText(message[i]);
            if (message[i + 1].equals("i am the sender")) {
                textmsg = graphic.getMessageSended();
            } else {
                textmsg = graphic.getMessageRecived();
            }
            messaggi.getChildren().add(textmsg);
            messaggi.setPrefHeight(graphic.getAumenta());
            scrollpane.setVvalue(1.0);
        }
        initializated=true;
    }
    public void  initialize(){
        withName.setText("User #"+bean.getWith());
        recivemsgArr();
        timeline.play();
    }
    @FXML
    protected void goToHome(ActionEvent event){
        timeline.stop();
        controller.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) {
        timeline.stop();
        controller.switchToISC(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event)  {
        timeline.stop();
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void touchedHome(ActionEvent event){
        BeanResultSearch visitBean=new BeanResultSearch();
        visitBean.touched(bean.getWith());
        timeline.stop();
        controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
    }
}
