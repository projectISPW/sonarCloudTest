package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.form.ResultForm;

import java.util.ArrayList;
import java.util.List;

public class CollectionFormController {
   public void setTouched(int formid){
       ControllerClass.setResultForm(formid);
   }
    public void  takeForm(){
       ControllerClass.setResultForm();
    }
    public String getUserid(){return ControllerClass.getUserUSR().getUserid();}
}
