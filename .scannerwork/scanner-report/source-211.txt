package progettoispw.letmeknow;

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

import java.io.IOException;
import java.util.Date;

import javafx.animation.Timeline;
import static java.lang.Thread.sleep;

public class ChatControllerInterf1 {
    @FXML
    protected AnchorPane messaggi;
    @FXML
    protected TextArea inputmsg;
    @FXML
    protected ScrollPane scrollpane;
    @FXML
    protected Text withName;
    protected boolean initializated;
    protected  PageMenu controller= new PageMenu();
    protected ChatBean bean;
    protected BeanResultSearch visitBean;
    protected  String [] message;
    protected  CSS graphic;
    protected Label textmsg;
    protected Timeline timeline;
    public ChatControllerInterf1() {
        bean=new ChatBean();
        visitBean=new BeanResultSearch();
        graphic=new CSS(true);
        initializated=false;
        timeline=new Timeline(new KeyFrame(Duration.millis(5000),this::recivemsgArr));
        timeline.setCycleCount(Timeline.INDEFINITE);//never stop
    }

    @FXML
    protected void sendMsg() {
        bean.newMsg(inputmsg.getText());
        recivemsgArr();
        inputmsg.setText("");
    }
    public void recivemsgArr(ActionEvent event){
        if(initializated) recivemsgArr();
    }
    public void  recivemsgArr() {
        bean.getChat();
        message = bean.getMSG();
        System.out.println("*******inizioscansione + *********"+new Date().toString());
        for (int i = 0; i < message.length; i += 2) {
            graphic.setText(message[i]);
            System.out.println(message[i]);
            if (message[i + 1].equals("i am the sender")) {
                textmsg = graphic.getMessageSended();
            } else {
                textmsg = graphic.getMessageRecived();
            }
            messaggi.getChildren().add(textmsg);
            messaggi.setPrefHeight(graphic.getAumenta());
            scrollpane.setVvalue(1.0);
        }
        System.out.println("*********finescansione********"+new Date().toString());
        initializated=true;
    }
    public void  initialize(){
        withName.setText("User #"+bean.getWith());
        recivemsgArr();
        this.timeline.play();
    }
    @FXML
    protected void goToHome(ActionEvent event){
        timeline.stop();
        controller.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        timeline.stop();
        controller.switchToISC(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        timeline.stop();
        controller.switchToPersonalForm(event);
    }
    @FXML
    private void touchedHome(ActionEvent event){
        visitBean.touched(bean.getWith());
        timeline.stop();
        controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
    }
}
