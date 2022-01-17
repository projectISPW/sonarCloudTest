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
import progettoispw.letmeknow.bean.beanResultSearch;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.Timeline;
import static java.lang.Thread.sleep;

public class ChatControllerInterf1 {
    @FXML
    AnchorPane messaggi;
    @FXML
    TextArea inputmsg;
    @FXML
    ScrollPane scrollpane;
    @FXML
    Text withName;
    boolean initializated;
    private PageMenu controller= new PageMenu();
    ChatBean bean;
    beanResultSearch visitBean;
    private String [] message;
    private CSS graphic;
    Label textmsg;
    Timeline timeline;
    public ChatControllerInterf1() {
        bean=new ChatBean();
        visitBean=new beanResultSearch();
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
    public void  initialize() throws InterruptedException {
           withName.setText("User #"+bean.getWith());
           System.out.println("stage inizializzato");
           recivemsgArr();
           this.timeline.play();
    }

    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        timeline.stop();
        controller.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        timeline.stop();
       controller.switchTo("initialSearchAndChat/interf1.fxml",event,"Your chat");
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
