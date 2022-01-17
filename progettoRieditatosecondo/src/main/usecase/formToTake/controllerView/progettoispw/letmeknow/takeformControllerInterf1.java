package progettoispw.letmeknow;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import progettoispw.letmeknow.bean.FormToTakeStatusBean;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
public class takeformControllerInterf1 {
    @FXML
    protected AnchorPane form;
    @FXML
    protected Text idForm;
    @FXML
    protected Slider sl1,sl2,sl3,sl4,sl5,sl6;
    @FXML
    protected Label lb1,lb2,lb3,lb4,lb5,lb6;
    @FXML
    protected ProgressBar progressBar;
    protected PageMenu controller= new PageMenu();
    protected Vector<Slider> sl;
    protected boolean [] values;
    protected  boolean [] locked;
    protected int [] response;
    protected void attach(Slider slider){
        this.sl.add(slider);
    }
    protected double progress=0;
    int indice=-1;
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
        sl=new Vector<Slider> ();
        attach(sl1);
        attach(sl2);
        attach(sl3);
        attach(sl4);
        attach(sl5);
        attach(sl6);
        Label[] labels= new Label[]{lb1, lb2, lb3, lb4, lb5, lb6};
        progressBar.setProgress(progress);
        progressBar.setStyle("-fx-accent:#7836ea;");
        for(Slider slider :sl){
            indice=sl.indexOf(slider);
            if(response[indice]!=-1){
                slider.setValue(response[indice]);
            }
        }

        for(Slider slider:sl ){
            slider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    indice=sl.indexOf(slider);
                    if(values[indice]==true){
                        progress+=0.17;
                        progressBar.setProgress(progress);
                        values[indice]=false;
                    }
                    if(locked[indice]==true){
                        slider.setValue(response[indice]);
                    }
                    labels[indice].setText(""+(int)slider.getValue());
                }
            });
        }
    }
    @FXML
    protected void save(ActionEvent event) {
        for (Slider slider : sl) {
            indice = sl.indexOf(slider);
            if (values[indice] == false) {
                //System.out.printf("*il valore dell elemento sl[%d] è pari a %d \n", indice, (int) slider.getValue());
                locked[indice]=true;
                response[indice]=(int)slider.getValue();
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
