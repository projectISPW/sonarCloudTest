package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import progettoispw.letmeknow.bean.GoToFormBean;

public class FormToTakeInterf1 {
    PageMenu controller;
    GoToFormBean bean;
    public FormToTakeInterf1(){
        controller=new PageMenu();
        bean= new GoToFormBean();
    }
    protected void takeForm(ActionEvent event){
        GoToFormBean takeFormBean=new GoToFormBean();
        int val=takeFormBean.getFormid();
        String name="formToTake/form"+val+"interf1.fxml";
        controller.switchTo(name,event,"fill the form");
    }
}
