package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import progettoispw.letmeknow.bean.HomepagePsychologistBean;

public class HomepagePsychologistInterf1 {
    HomepagePsychologistBean bean;
    Page controller;
    @FXML
    Label count1;
    @FXML
    Label count2;
    @FXML
    Label count3;
    @FXML
    Label month;
    @FXML
    TextArea feedback;
    public static final String  USERS="users";
    public HomepagePsychologistInterf1(){
        controller=new PageMenu();
        bean=new HomepagePsychologistBean();
    }
    public void initialize(){
        count1.setText((int)bean.getForms()+USERS);
        count2.setText((int)bean.getForms()+USERS);
        count3.setText((int)bean.getForms()+USERS);
        month.setText(bean.getMonth());
    }
    public void increm() {
        bean.incremMonth();
        initialize();
    }
    public void decrem() {
        bean.decremMonth();
        initialize();
    }
    @FXML
    public int  getSelected(ActionEvent event){
        Button button=(Button) event.getTarget();
        int val=0;
        switch(button.getId()){
            case "form1" :{
                bean.setSelected(1);
                val=1;
                break;
            }
            case "form2" :{
                bean.setSelected(2);
                val=2;
                break;
            }
            case "form3" :{
                bean.setSelected(3);
                val=3;
                break;
            }
            default :{
                event.consume();
            }
        }
        return val;
     }
     @FXML
     public void select(ActionEvent event){
        int formid=getSelected(event);
        controller.switchTo("formResultPsychologist/form"+formid+"interf1.fxml",event,"users results");
     }
    public void suggestForm(){
        feedback.setStyle("-fx-border-color: white;");
        boolean bool =bean.suggestForm(feedback.getText());
        if(bool){
            feedback.setText("");
        }
        else{
            feedback.setStyle("-fx-border-color: red;");
        }
    }
    public void backTo(){
        controller.backTo();
    }
    public void goToSettings(ActionEvent event ){
        controller.switchTo("settingsPsychologist/interf1.fxml",event,"Settings");
    }
}
