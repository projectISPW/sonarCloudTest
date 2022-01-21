package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.ISCBean;
import progettoispw.letmeknow.bean.BeanResultSearch;

public class ResultSearchControllerInterf1 {
    PageMenu controller=new PageMenu();
    @FXML
    Group g1;
    @FXML
    Group g2;
    @FXML
    Group g3;
    @FXML
    Group g4;
    Group[]group;
    @FXML
    Text uid1;
    @FXML
    Text uid2;
    @FXML
    Text uid3;
    @FXML
    Text uid4;
    Text[] vUid;
    String [] strUid=new String[4];
    @FXML
    Text des1;
    @FXML
    Text des2;
    @FXML
    Text des3;
    @FXML
    Text des4;
    Text [] vDes;
    String [] strDes=new String[4];
    @FXML
    Text goal1;
    @FXML
    Text goal2;
    @FXML
    Text goal3;
    @FXML
    Text goal4;
    Text [] vGoal;
    String [] strGoal=new String[4];
    ISCBean chatBean;
    int nval;
    BeanResultSearch bean;
    public ResultSearchControllerInterf1(){
        nval=4;
        bean=new BeanResultSearch(nval);
        chatBean=new ISCBean();
    }
    public void initialize(){
        vUid=new  Text[]{uid1,uid2,uid3,uid4};
        vDes=new Text[]{des1,des2,des3,des4};
        vGoal=new Text[]{goal1,goal2,goal3,goal4};
        group=new Group[]{g1,g2,g3,g4};
        outputVal();
    }
    @FXML
    public void outputVal(){
        for(int i=0;i<group.length;i++){
            if (group[i].getOpacity()==0)group[i].setOpacity(1);
        }
        strDes= bean.exitDes();
        strGoal=bean.exitGoal();
        strUid= bean.exitUID();
        for(int i=0;i<nval;i++){
            if(strUid[i]==null || strDes[i]==null || strGoal[i]==null) group[i].setOpacity(0);
            vUid[i].setText("Id:"+strUid[i]);
            vDes[i].setText("About me: " +strDes[i]);
            vGoal[i].setText("Working on: "+strGoal[i]);
        }
    }
    @FXML
    protected void goBack(ActionEvent event)  {
        controller.switchTo("search/interf1.fxml",event,"Search");
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        controller.switchToHome(event);
    }
    protected void visit(ActionEvent event,int i){
        if(group[i].getOpacity()==1){
            bean.touched(strUid[i]);
            controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
        }
    }
    @FXML
    protected void visit1(ActionEvent event){
        visit(event,0);
    }
    @FXML
    protected void visit2(ActionEvent event){
        visit(event,1);
    }
    @FXML
    protected void visit3(ActionEvent event){
        visit(event,2);
    }
    @FXML
    protected void visit4(ActionEvent event){
        visit(event,3);
    }
    private void visit1(ActionEvent event,int i ){
        chatBean.touched(strUid[i]);
        controller.switchTo("chat/interf1.fxml",event,"Visit");
    }

    public void touchChat1(ActionEvent event) {
        visit1(event,0);
    }

    public void touchChat4(ActionEvent event) {
        visit1(event,3);
    }

    public void touchChat3(ActionEvent event) {
        visit1(event,2);
    }

    public void touchChat2(ActionEvent event) {
        visit1(event,1);
    }
}
