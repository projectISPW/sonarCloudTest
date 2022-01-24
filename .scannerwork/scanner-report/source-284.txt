package progettoispw.letmeknow;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.BeanResultSearch;

import java.io.IOException;

public class InitialSearchAndChatControllerInterf1 {
    private PageMenu controller ;
    private String userid;
    private final static String UID="userid";
    @FXML
    Group group1;
    @FXML
    Group group2;
    @FXML
    Group group3;
    @FXML
    Group group4;
    @FXML
    Group extGroup1;
    @FXML
    Group extGroup2;
    @FXML
    Group extGroup3;
    @FXML
    Group extGroup4;
    @FXML
    TextField searchBar;
    int nval;
    ISCBean bean;
    BeanResultSearch beanVisit;
    String [] uids;
    public InitialSearchAndChatControllerInterf1(){
        nval=4;
        bean=new ISCBean(nval);
        beanVisit=new BeanResultSearch(4);
        uids=new String[4];
        controller=new PageMenu();
    }
    public void initialize(){
        userid=bean.getUserid();
        outputValChat();
        searchBar.textProperty().addListener((observableValue, s, t1) -> {
            if(searchBar.getText().equals("")){
                System.out.println("on reset");
                bean.reset();
            }
        });
    }

    @FXML
    public  void outputValChat(){
        Group [] chatExtGroup=new Group[]{extGroup1,extGroup2,extGroup3,extGroup4};
        Group []chatGroup=new Group []{group1,group2,group3,group4};
        for(int i=0;i<nval;i++){
            chatExtGroup[i].setOpacity(1);
        }
        String [][] innerusers =bean.exitUid();
        String [] strUid=innerusers[0];
        String [] strLst=innerusers[1];
        for(int i=0;i<nval;i++){
            if(strUid[i]==null || strLst[i]==null){
                chatExtGroup[i].setOpacity(0);
            }
            ObservableList<Node> inner= chatGroup[i].getChildren();
            for(Node elem:inner){
                Text text=(Text)elem;
                if(elem.getId().equals(UID)){
                    uids[i]=strUid[i];
                    text.setText("#"+strUid[i]);
                }
                else text.setText(strLst[i]);
            }
        }
    }

    private String getUid(String string){
        int indice=-1;
        String sub;
        for(int i=0;i<3;i++)System.err.println("utente in chat , dopo uso .:"+uids[i]);
        if(string==null ||string.length()<8 )return string ;
        else{
            indice=string.indexOf("||");
            sub=string.substring(0,indice);
            if(sub.equals(userid)==false) {
                return sub;
            }
            return string.substring(indice+2);
            }
        }
    private String[] getUids(String[] uids) {
        for(int i=0;i<3;i++){
            uids[i]=getUid(uids[i]);
        }
        return uids;
    }
    public void setUIDS(String [] input){
        uids=input;
    }
    public void touchChat(ActionEvent event){
        Button button=(Button) event.getTarget();
        if(button.getOpacity()<1)return ;
        uids=getUids(uids);
        System.out.println("utente cliccato " +button.getId());
        switch(button.getId()){
            case "chat1" :{
                bean.touched(uids[0]);
                System.out.println("toccata chat 1");
                break;
            }
            case "chat2" :bean.touched(uids[1]);break;
            case "chat3" :bean.touched(uids[2]);break;
            case "chat4" :bean.touched(uids[3]);break;
            default :{
                event.consume();
            }
        }
        controller.switchTo("chat/interf1.fxml",event,"chat");
    }
    public void visit(ActionEvent event) {
       ResultSearchControllerInterf1 resultSearch =new ResultSearchControllerInterf1();
       uids=getUids(uids);
       resultSearch.setUids(uids);
       resultSearch.visit(event);
    }
    @FXML
    protected void goToHome(ActionEvent event)  {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event){
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        controller.switchToSettings(event);
    }
    @FXML
    protected void goToSearch(ActionEvent event) {
        controller.switchTo("search/interf1.fxml",event,"Search");
    }
    @FXML
    protected void searchMessage(){
        bean.search(searchBar.getText());
        outputValChat();
    }

}
