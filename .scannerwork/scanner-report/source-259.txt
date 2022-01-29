//utenteusr never used. should I cancel it with also library?

package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.ResultForm;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

public class FormResultController {
    ResultForm form;
    int [] values;
    public FormResultController(){
        form= ControllerClass.getResultForm();
    }
    public int[] getValResponse(){
        values=form.getRisposte();
        return form.getRisposte();
    }
    public int [] getParam () {
        return form.getParam();
    }
    public String getDate () {
        return form.getDate();
    }

}