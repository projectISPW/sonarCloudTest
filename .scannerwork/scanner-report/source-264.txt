package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.GoToFormController;

public class GoToFormBean {
    GoToFormController controller;
    public GoToFormBean (){
        controller =new GoToFormController();
    }
    public int getFormid(){
        return controller.getFormid();
    }
}
