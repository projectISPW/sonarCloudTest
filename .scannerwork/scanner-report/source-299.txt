package progettoispw.letmeknow;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.BeanResultSearch;

public class ResultSearchControllerInterf1 {
    @FXML
    Group group1;
    @FXML
    Group group2;
    @FXML
    Group group3;
    @FXML
    Group group4;
    String [] uids;
    private static final String UID_CONTENT ="Userid  : #";
    private static final String MSG_WORKON ="Working On :";
    private static final String DESCRIPTION ="About me :";
    private PageMenu controller;
    BeanResultSearch beanVisit;
    ISCBean chatBean;
    int nval;
    public ResultSearchControllerInterf1(){
        nval=4;
        beanVisit=new BeanResultSearch(nval);
        chatBean=new ISCBean();
        controller=new PageMenu();
        uids=new String[nval];
    }
    public void initialize(){
        outputVal();
    }
    @FXML
    public void outputVal(){

        Group [] visitGroup=new Group[]{group1,group2,group3,group4};
        for(int i=0;i<nval;i++){
            visitGroup[i].setOpacity(1);
        }
        String [] [] users= beanVisit.exitDes();
        String[] strDes= users[2];
        String[] strGoal=users[1];
        String[] strUid=users[0];
        for(int i=0;i<nval;i++){
            ObservableList<Node> externList= visitGroup[i].getChildren();
            Group group =(Group)externList.get(2);
            ObservableList<Node>inner=group.getChildren();
            if(strUid[i]!=null){
                for(Node elem:inner){
                    Text text=(Text)elem;
                    if(text.getText().contains(UID_CONTENT)){
                        text.setText(UID_CONTENT +strUid[i]);
                        uids[i]=strUid[i];
                    }
                    else if(text.getText().contains(MSG_WORKON)){
                        text.setText(MSG_WORKON+strGoal[i]);
                        System.err.println("obiettivo in ingresso" + strGoal[i]);
                    }
                    else if(text.getText().contains(DESCRIPTION))text.setText(DESCRIPTION+strDes[i]);
                }
            }
            else {
                visitGroup[i].setOpacity(0);
            }}
    }
    @FXML
    public void touchChat(ActionEvent event){
        InitialSearchAndChatControllerInterf1 iscController=new InitialSearchAndChatControllerInterf1();
        iscController.setUIDS(uids);
        iscController.touchChat(event);
    }
    public void setUids(String [] input){
        uids=input;
    }
    @FXML
    public void visit(ActionEvent event) {
        Button button = (Button) event.getTarget();
        if (button.getOpacity() < 1) return;
        System.out.println(button.getId());
        switch (button.getId()) {
            case "home1":
                System.err.println("andato su home 1");
                beanVisit.touched(uids[0]);
                break;
            case "home2":
                beanVisit.touched(uids[1]);
                break;
            case "home3":
                beanVisit.touched(uids[2]);
                break;
            case "home4":
                beanVisit.touched(uids[3]);
                break;
            default: {
                event.consume();
            }
        }
        controller.switchTo("homepageOthers/interf1.fxml",event,"visit");
    }
    @FXML
    protected void goBack()  {
        controller.backTo();
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        controller.switchToHome(event);
    }

}
