//ln 45-46 duplicated code, i put it out of the if/else
package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.FormToTakeStatusBean;
import progettoispw.letmeknow.bean.UseridBean;

public class formCollectionResultsInterf1 implements Interf1ButtonBar{
    PageMenu controller = new PageMenu();
    FormToTakeStatusBean bean;
    UseridBean homeBean;
    @FXML
    Text idUser;
    public void initialize(){
        homeBean=new UseridBean();
        idUser.setText("User"+homeBean.getUserId());
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        controller.switchToSettings(event);
    }
    private void which(int i,ActionEvent event){
        bean=new FormToTakeStatusBean(i);
        String name,title;
        if(bean.getComplete()==6){
            name="formResult/form"+i+"interf1.fxml";
        }
        else{
            name="formToTake/form"+i+"interf1.fxml";
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
        }

    }
    @FXML
    protected void takeForm(ActionEvent event){
        FormToTakeInterf1 takeForm=new FormToTakeInterf1();
        takeForm.takeForm(event);
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
