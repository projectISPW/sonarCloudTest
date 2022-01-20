package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.FormToTakeStatusController;

public class FormToTakeStatusBean {
    int formid;
    FormToTakeStatusController controller;
    public FormToTakeStatusBean(int inputformid){
        System.out.println("id form nel bean"+inputformid);
        formid=inputformid;
        controller=new FormToTakeStatusController(formid);
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
}
