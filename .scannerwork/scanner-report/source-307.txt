package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.FormPsychologistResultController;


public class FormPsychologistResultBean {
    FormPsychologistResultController controller;
    public FormPsychologistResultBean(){
        controller=new FormPsychologistResultController();
    }
    public float [] getSelected(){
        return controller.getSelected();
    }
}
