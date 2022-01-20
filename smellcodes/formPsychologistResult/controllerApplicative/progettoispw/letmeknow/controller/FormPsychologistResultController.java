package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utentipsy.UtentePsy;

public class FormPsychologistResultController {
    UtentePsy user;
    public FormPsychologistResultController(){
        user=ControllerClass.getUserPsy();
    }
    public float [] getSelected(){
        float [] inner=user.getSelected();
        for(int i=0 ; i <7 ;i++)System.out.println(inner[i]);
        return user.getSelected();
    }
}
