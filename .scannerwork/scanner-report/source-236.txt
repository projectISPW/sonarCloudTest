//ln 45-46 duplicated code, i put it out of the if/else
package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.FormToTakeStatusBean;
import progettoispw.letmeknow.bean.GoToFormBean;
import progettoispw.letmeknow.bean.UseridBean;

import java.io.IOException;

public class formCollectionResultsInterf1 {
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
    protected void goToSettings(ActionEvent event) throws IOException {
        controller.switchTo("settings/interf1.fxml",event,"Settings");
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchTo("initialSearchAndChat/interf1.fxml",event,"What do you need ? ");
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchTo("homepage/interf1.fxml",event,"Home");
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
        GoToFormBean takeFormBean=new GoToFormBean();
        int val=takeFormBean.getFormid();
        String name="formToTake/form"+val+"interf1.fxml";
        controller.switchTo(name,event,"fill the form");
    }
}
