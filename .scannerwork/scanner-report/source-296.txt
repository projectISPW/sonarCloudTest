package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.HomepageController;

public class UseridBean {
    HomepageController controller;
    public UseridBean(){
        controller=new HomepageController();
    }
    public String getUserId(){
        return controller.getUserID();
    }
}
