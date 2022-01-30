
package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.CollectionFormBean;
import progettoispw.letmeknow.bean.FormToTakeStatusBean;

public class FormCollectionResultsInterf1 {
    PageMenu controller;
    CollectionFormBean bean;
    public static final String INTERF="interf1.fxml";
    @FXML
    protected Text idUser;
    public FormCollectionResultsInterf1(){
        bean=new CollectionFormBean();
        controller=new PageMenu();
    }
    public void initialize(){
        idUser.setText("User"+ bean.getUid());
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        controller.switchToSettings(event);
    }
    protected  void which(int i,ActionEvent event){
        bean.setTouched(i);
        String name;
        String title;
        FormToTakeStatusBean formBean=new FormToTakeStatusBean();
        if(formBean.getComplete()==6){
            name="formResult/form"+i+INTERF;
        }
        else{
            name="formToTake/form"+i+INTERF;
        } title="form"+i;
        controller.switchTo(name,event,title);
    }
    @FXML
    protected void urResult(ActionEvent event) {
        Button button=(Button) event.getTarget();
        switch(button.getText()){
            case "FORM 3":{
                which(3,event);
                break;
            }
            case "FORM 1":{
                which(1,event);
                break;
            }
            case "FORM 2":{
                which(2,event);
                break;
            }
            default:{
                event.consume();
            }
        }

    }
    @FXML
    public void takeForm(ActionEvent event){
        bean.takeForm();
        FormToTakeStatusBean innerBean=new FormToTakeStatusBean();
        int val = innerBean.getFormId();
        if(innerBean.getComplete()<=6){
            controller.switchTo("formToTake/form"+val+INTERF,event,"form"+val);
        }
        else{
            controller.switchTo("formResult/form"+val+INTERF,event,"form"+val);
        }
    }
    @FXML
    protected  void goToISC(ActionEvent event){
        controller.switchToISC(event);
    }
    @FXML
    protected  void goToPersonalForm(ActionEvent event){
        controller.switchToHome(event);
    }
    @FXML
    protected  void goToHome(ActionEvent event){controller.switchToHome(event);}
}
