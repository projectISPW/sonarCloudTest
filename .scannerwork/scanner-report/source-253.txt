package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.Factory;
import progettoispw.letmeknow.controller.form.ResultForm;

public class GoToFormController {
    ResultForm form;
    public GoToFormController(){
        ControllerClass factory=new ControllerClass();
        form=new ResultForm(factory.getUserUSR().getUserid());
    }
    public int getFormid(){
        return form.getFormid();
    }
}
