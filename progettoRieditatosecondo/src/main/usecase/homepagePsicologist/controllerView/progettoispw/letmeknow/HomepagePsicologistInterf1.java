package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import progettoispw.letmeknow.bean.HomepagePsicologistBean;

import java.util.Calendar;

public class HomepagePsicologistInterf1 {
    HomepagePsicologistBean bean;
    Page controller=new Page();
    @FXML
    Label count1,count2,count3;
    @FXML
    Label month;
    @FXML
    TextArea feedback;
    public HomepagePsicologistInterf1(){
        bean=new HomepagePsicologistBean();
    }
    public void initialize(){
        count1.setText("completed by  :\n"+(int)bean.getForms()[0]+"users");
        count2.setText("completed by  :\n"+(int)bean.getForms()[0]+"users");
        count3.setText("completed by  :\n"+(int)bean.getForms()[0]+"users");
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
    public void goToResult1(ActionEvent event) {
        bean.setSelected(1);
        controller.switchTo("formResultPsicologist/form1interf1.fxml",event,"users results");
    }

    public void goToResult2(ActionEvent event) {
        bean.setSelected(2);
        controller.switchTo("formResultPsicologist/form2interf1.fxml",event,"users results");
    }
    public void goToResult3(ActionEvent event) {
        bean.setSelected(3);
        controller.switchTo("formResultPsicologist/form3interf1.fxml",event,"users results");
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
        controller.switchTo("settingsPsicologist/interf1.fxml",event,"Settings");
    }
}
