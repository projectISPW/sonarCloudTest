//utenteusr never used. should I cancel it with also library?

package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.ResultForm;

public class FormResultController {
    ResultForm form;
    int [] values;
    public FormResultController(){
        form= ControllerClass.getResultForm();
    }
    public int[] getValResponse(){
        values=form.setAnswers();
        return form.setAnswers();
    }
    public int [] getParam () {
        return form.getParam();
    }
    public String getDate () {
        return form.getDate();
    }

}