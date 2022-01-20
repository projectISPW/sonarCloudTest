package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ControllerClass;
import progettoispw.letmeknow.controller.FormPsicologistResultController;
import progettoispw.letmeknow.controller.HomepagePsicologistController;

public class FormPsicologistResultBean {
    FormPsicologistResultController controller;
    public FormPsicologistResultBean(){
        controller=new FormPsicologistResultController();
    }
    public float [] getSelected(){
        return controller.getSelected();
    }
}
