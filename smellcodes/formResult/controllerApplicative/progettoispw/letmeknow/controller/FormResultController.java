//utenteusr never used. should I cancel it with also library?

package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.ResultForm;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

public class FormResultController {
    String userid;
    int formid;
    ResultForm form;
    UtenteUsr user;
    int [] values;
    public FormResultController(int inputform){
        userid= ControllerClass.getUserUSR().getUserid();
        formid=inputform;
        form= new ResultForm(userid,formid);
    }
    public int[] getValResponse(){
        values=form.getRisposte();
        return form.getRisposte();
    }
    public boolean[] getStatus() {
        boolean [] bool=new boolean[values.length];
        for(int i=0;i<values.length;i++){
            if(values[i]>=1)bool[i]=true;
            else{
                bool[i]=false;
            }
        }
        return bool;
    }
    public int [] getParam () {
        return form.getParam();
    }
    public String getDate () {
        return form.getDate();
    }

}