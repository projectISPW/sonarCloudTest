package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.ResultForm;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class FormToTakeStatusController {
    String userid;
    int formid;
    ResultForm form;
    int [] values;
    public FormToTakeStatusController(int inputform){
        ControllerClass factory=new ControllerClass();
        userid= factory.getUserUSR().getUserid();
        formid=inputform;
        form= new ResultForm(userid,formid);
    }
    public void setValResponse(int [] passaggio){
        form.setRisposte(passaggio);
    }
    public int[] getValResponse(){
        values=form.getRisposte();
        return form.getRisposte();
    }
    public String getUserid(){
        return userid;
    }
    public int getValComplete() {
        return form.getComplete();
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

}