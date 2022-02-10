package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.psyuser.PsyUser;

public class FormPsychologistResultController {
    PsyUser user;
    public FormPsychologistResultController(){
        user= ConcretePsyUser.getPsyUser();
    }
    public float [] getSelected(){
        return user.getSelected();
    }
}
