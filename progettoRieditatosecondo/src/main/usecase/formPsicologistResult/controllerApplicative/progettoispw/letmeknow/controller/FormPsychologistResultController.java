package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utentipsy.UtentePsy;

public class FormPsychologistResultController {
    UtentePsy user;
    public FormPsychologistResultController(){
        user=ControllerClass.getUserPsy();
    }
    public float [] getSelected(){
        float [] inner=user.getSelected();
        return user.getSelected();
    }
}
