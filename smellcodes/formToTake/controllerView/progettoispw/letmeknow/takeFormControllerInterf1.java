//same line variables, I put them on different lines

package progettoispw.letmeknow;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import progettoispw.letmeknow.bean.FormToTakeStatusBean;

import java.io.IOException;


public class takeFormControllerInterf1 {
    @FXML
    protected AnchorPane form;
    @FXML
    protected Text idForm;
    @FXML
    protected Slider sl1;
    @FXML
    protected Slider sl2;
    @FXML
    protected Slider sl3;
    @FXML
    protected Slider sl4;
    @FXML
    protected Slider sl5;
    @FXML
    protected Slider sl6;
    @FXML
    protected Label lb1;
    @FXML
    protected Label lb2;
    @FXML
    protected Label lb3;
    @FXML
    protected Label lb4;
    @FXML
    protected Label lb5;
    @FXML
    protected Label lb6;
    @FXML
    protected ProgressBar progressBar;
    protected PageMenu controller= new PageMenu();
    protected Slider[] sl;
    protected boolean [] values;
    protected  boolean [] locked;
    protected int [] response;
    protected double progress=0;

    protected FormToTakeStatusBean startStatus;
    protected boolean[] not(boolean []bool){
        boolean [] currbool=new boolean[6];
        for(int i=0;i< bool.length;i++){
            if(bool[i]) currbool[i]=false;
            else currbool[i]=true;
        }
        return currbool;
    }
    public void initialize(){
        if(startStatus.getComplete()==6){
            System.out.println("i am here");
            goBack();
        }
        response=startStatus.exitValStatus();
        locked=startStatus.exitStatus();
        values=not(locked);
        progress= startStatus.getComplete()*0.17;
        sl=new Slider[] {sl1,sl2,sl3,sl4,sl5,sl6};
        Label[] labels= new Label[]{lb1, lb2, lb3, lb4, lb5, lb6};
        progressBar.setProgress(progress);
        for(int i=0;i<6;i++){
                 if(response[i]!=-1){
                       sl[i].setValue(response[i]);
                 }
                int finalI = i;
                sl[i].valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    if(values[finalI]==true){
                        progress+=0.17;
                        progressBar.setProgress(progress);
                        values[finalI]=false;
                    }
                    if(locked[finalI]==true){
                        sl[finalI].setValue(response[finalI]);
                    }
                    labels[finalI].setText(""+(int)sl[finalI].getValue());
                }
            });
        }
    }
    @FXML
    protected void save(ActionEvent event) {
        for (int i=0;i<6;i++) {
            if (values[i] == false) {
                //System.out.printf("*the value of the element sl[%d] is %d \n", index, (int) slider.getValue());
                locked[i]=true;
                response[i]=(int)sl[i].getValue();
            }
        }
        startStatus.inputValStatus(response);
        initialize();
    }
    @FXML
    protected void goBack() {
        controller.backTo();
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchToChat(event);
    }
}
