package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.ResultForm;

public class FormToTakeStatusController {
    ResultForm form;
    public FormToTakeStatusController(){
        form= ControllerClass.getResultForm();
    }
    public int getFormId(){
        return form.getFormid();
    }
    public void setValResponse(int [] passaggio){
        form.setAnswers(passaggio);
    }
    public int[] getValResponse(){
        return form.getAnswers();
    }
    public String getUserid(){
        return form.getUserid();
    }
    public int getValComplete() {
        return form.getComplete();
    }
    public boolean[] getStatus() {
        int [] values=form.getAnswers();
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