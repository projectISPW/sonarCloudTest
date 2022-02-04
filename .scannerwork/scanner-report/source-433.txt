package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.psyuser.PsyUser;

public class FormPsychologistResultController {
    PsyUser user;
    public FormPsychologistResultController(){
        user=ControllerClass.getUserPsy();
    }
    public float [] getSelected(){
        return user.getSelected();
    }
}
