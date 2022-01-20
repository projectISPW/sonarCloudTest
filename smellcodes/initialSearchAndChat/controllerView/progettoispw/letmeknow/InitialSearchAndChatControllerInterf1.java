//used to be variables on same line
package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.BeanResultSearch;

import java.io.IOException;

public class InitialSearchAndChatControllerInterf1 {
    private PageMenu controller ;
    private String userid;
    @FXML
    Text lst1;
    Text lst2;
    Text lst3;
    Text lst4;
    Text[] lst;
    String [] strLst=new String[4];
    @FXML
    Text uid1;
    Text uid2;
    Text uid3;
    Text uid4;
    String [] strUid=new String[4];
    Text[] uid;
    @FXML
    Button home1;
    Button home2;
    Button home3;
    Button home4;
    Button[] home;
    @FXML
    Button chat1;
    Button chat2;
    Button chat3;
    Button chat4;
    Button[] chat;
    @FXML
    TextField searchBar;
    int nval;
    ISCBean bean;
    BeanResultSearch beanVisit;
    public InitialSearchAndChatControllerInterf1(){
        nval=4;
        bean=new ISCBean(nval);
        beanVisit=new BeanResultSearch(4);
        controller=new PageMenu();
    }
    public void initialize(){
        userid=bean.getUserid();
        lst=new Text[]{lst1,lst2,lst3,lst4};
        uid=new Text[]{uid1,uid2,uid3,uid4};
        chat= new Button[]{chat1, chat2, chat3, chat4};
        home=new Button[]{home1,home2,home3,home4};
        outputVal();
        searchBar.textProperty().addListener((observableValue, s, t1) -> {
            if(searchBar.getText()==""){
                System.out.println("on reset");
                bean.reset();
            }
        });
    }

    @FXML
    public void outputVal(){
        for(int i=0;i<nval;i++){
            chat[i].setOpacity(1);
            home[i].setOpacity(1);
        }
        strUid= bean.exitUid();
        strLst=bean.exitMsg();
       for(int i=0;i<nval;i++){
           if(strUid[i]==null || strLst[i]==null){
               System.out.println(i);
               chat[i].setOpacity(0);
               home[i].setOpacity(0);
           }
           else{
            uid[i].setText("Id :  #"+strUid[i]);
            lst[i].setText(strLst[i]);
        }}
    }
    @FXML
    protected void homeTouch1(ActionEvent event ){
        visit(event,0);
    }
    @FXML
    protected void homeTouch2(ActionEvent event ){
        visit(event,1);
    }
    @FXML
    protected void homeTouch3(ActionEvent event ){
        visit(event,2);
    }
    @FXML
    protected void homeTouch4(ActionEvent event ){
        visit(event,3);
    }
    private String getUid(String string){
        int indice=-1;
        String sub;
        if(string.length()<8)return string ;
        else{
            indice=string.indexOf("||");
            sub=string.substring(0,indice);
            if(sub.equals(userid)==false) {
                return sub;
            }
            return string.substring(indice+2);
            }
        }

    protected void visit(ActionEvent event,int i){
        String actual;
        if(chat[i].getOpacity()==1){
            actual=getUid(strUid[i]);
            bean.touched(actual);
            beanVisit.touched(actual);
            controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
        }
    }
    protected void visit1(ActionEvent event,int i){
        String actual=new String();
        if(chat[i].getOpacity()==1){
            actual=getUid(strUid[i]);
            bean.touched(actual);
            controller.switchTo("chat/interf1.fxml",event,"chat");
        }
    }
    @FXML
    protected void chatTouch1(ActionEvent event ){
        visit1(event,0);
    }

    @FXML
    protected void chatTouch2(ActionEvent event ){
        visit1(event,1);
    }
    @FXML
    protected void chatTouch3(ActionEvent event ){
        visit1(event,2);
    }
    @FXML
    protected void chatTouch4(ActionEvent event ){
        visit1(event,3);
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }

    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        controller.switchToSettings(event);
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchTo("chat/interf1.fxml",event,"Chat");
    }
    @FXML
    protected void goToSearch(ActionEvent event) throws IOException {
        controller.switchTo("search/interf1.fxml",event,"Search");
    }
    @FXML
    protected void searchMessage(){
        bean.search(searchBar.getText());
        outputVal();
    }

}
