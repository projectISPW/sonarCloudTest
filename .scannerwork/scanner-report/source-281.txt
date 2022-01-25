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
    protected Group group1;
    @FXML
    protected Group group2;
    @FXML
    protected Group group3;
    @FXML
    protected Group group4;
    Group [] visitGroup;
    String [] uids;
    static final String UID_CONTENT ="Userid  : #";
    static final String MSG_WORKON ="Working On :";
    static final String DESCRIPTION ="About me :";
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
        visitGroup=new Group[]{group1,group2,group3,group4};
        outputVal();
    }

    public String[] ouputVal_prev(Group [] input, int inputnval, String[] output){
        visitGroup=input;
        nval=inputnval;
        beanVisit=new BeanResultSearch(nval);
        uids=new String[nval];

        return outputVal();
    }
    @FXML
    public String [] outputVal(){
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
                    }
                    else if(text.getText().contains(DESCRIPTION))text.setText(DESCRIPTION+strDes[i]);
                }
            }
            else {
                visitGroup[i].setOpacity(0);
            }}
        return uids;
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
        switch (button.getId()) {
            case "home1":
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
    protected void goToHome(ActionEvent event) {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event){
        controller.switchToPersonalForm(event);
    }

}
