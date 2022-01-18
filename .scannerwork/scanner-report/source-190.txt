package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utentiPsy.UtentePsy;

public class FormPsicologistResultController {
    UtentePsy user;
    public FormPsicologistResultController(){
        user=ControllerClass.getUserPsy();
    }
    public float [] getSelected(){
        float [] inner=user.getSelected();
        for(int i=0 ; i <7 ;i++)System.out.println(inner[i]);
        return user.getSelected();
    }
}
