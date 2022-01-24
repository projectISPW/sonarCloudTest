package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.FormResultController;

public class FormResultBean {
    int formid;
    FormResultController controller;
    public FormResultBean(int inputformid){
        System.out.println("id form in bean"+inputformid);
        formid=inputformid;
        controller=new FormResultController(formid);
    }
    public int[] exitValStatus(){
        return controller.getValResponse();
    }
    public int [] getParam(){
        return controller.getParam();
    }
    public String getData(){
        return controller.getDate();
    }
}

