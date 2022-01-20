//spelling check
package progettoispw.letmeknow;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.FormPsychologistResultBean;

public class FormPsychologistResultInterf1 {
    @FXML
    Text by;
    @FXML
    Slider sl1,sl2,sl3,sl4,sl5,sl6;
    Slider [] sliders;
    FormPsychologistResultBean bean;
    Page controller;
    public FormPsychologistResultInterf1(){
        bean=new FormPsychologistResultBean();
        controller=new Page();
    }
    public void initialize(){
        sliders=new Slider[]{sl1,sl2,sl3,sl4,sl5,sl6};
        float [] values= bean.getSelected();
        for(int i=0;i<6;i++){
            int index = i;
            sliders[i].setValue(values[index+1]);
            sliders[i].valueProperty().addListener(new ChangeListener<>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    sliders[index].setValue(values[index+1]);
                }
            });
        }
        by.setText((int)values[0]+"users");
    }
    @FXML
    public void goBack(){
        controller.backTo();
    }
}
