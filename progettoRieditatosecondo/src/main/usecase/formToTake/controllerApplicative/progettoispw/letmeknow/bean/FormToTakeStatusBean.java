package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.FormToTakeStatusController;

public class FormToTakeStatusBean {
    FormToTakeStatusController controller;
    public FormToTakeStatusBean(){
        controller=new FormToTakeStatusController();
    }
    public int[] exitValStatus(){
        return controller.getValResponse();
    }
    public void inputValStatus(int [] inputint){
        controller.setValResponse(inputint);
    }
    public int getComplete(){
        return controller.getValComplete();
    }
    public boolean[] exitStatus() {
        return controller.getStatus();
    }
    public int getFormId(){
        int val=controller.getFormId();
        if(val>=1 && val <=3){
            return val;
        }
        return 1;
    }
}
