package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.FormResultController;

public class FormResultBean {
    FormResultController controller;
    public FormResultBean(){
        controller=new FormResultController();
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

