package progettoispw.letmeknow;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import progettoispw.letmeknow.bean.beanResultSearch;

import java.io.IOException;
import java.util.Date;

public class ChatControllerInterf2 {
    @FXML
    AnchorPane messaggi;
    @FXML
    TextArea inputmsg;
    @FXML
    ScrollPane scrollpane;
    @FXML
    Text withName;
    @FXML
    AnchorPane listUtenti;

    @FXML
    TextField searchBar;
    boolean initializated;
    private PageMenu controller= new PageMenu();
    ChatBean bean;
    ISCBean iscBean;
    beanResultSearch visitBean;
    private String [] message;
    private CSS graphic;
    private String userid;
    Label textmsg;
    Timeline timeline;
    public ChatControllerInterf2(){
        bean=new ChatBean();
        iscBean=new ISCBean();
        visitBean=new beanResultSearch();
        graphic=new CSS(false);
        initializated=false;
        userid=bean.getUid();
        timeline=new Timeline(new KeyFrame(Duration.millis(15000),this::recivemsgArr));
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
        addUser();
        this.timeline.play();
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
    private void visit(String input){
        if(input.length()>=8){
            input=checkUsrId(input);
        }
        iscBean.touched(input);
        visitBean.touched(input);
    }
    private void goChat(ActionEvent event){
        Button button=(Button)event.getTarget();
        String who=button.getText();
        who=checkUsrId(who);
        System.out.println("visit home"+who);
        iscBean.touched(who);
        controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
    }

    public  void addUser(){
        Button userButton;
        Label msgLabel;
        String [] uid= iscBean.exitUid();
        String [] msg=iscBean.exitMsg();
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
