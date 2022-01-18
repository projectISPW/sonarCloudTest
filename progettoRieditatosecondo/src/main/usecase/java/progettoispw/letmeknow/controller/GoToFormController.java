package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.ResultForm;

public class GoToFormController {
    ResultForm form;
    public GoToFormController(){
        form=new ResultForm(ControllerClass.getUserUSR().getUserid());
    }
    public int getFormid(){
        return form.getFormid();
    }
}
