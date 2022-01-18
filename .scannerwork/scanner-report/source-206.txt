package progettoispw.letmeknow;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import progettoispw.letmeknow.bean.FormToTakeStatusBean;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
public class takeform2ControllerInterf1 extends takeformControllerInterf1 {
    public takeform2ControllerInterf1(){
        super.startStatus=new FormToTakeStatusBean(2);
    }

}
