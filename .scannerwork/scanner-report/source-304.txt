package progettoispw.letmeknow.controller;

public class CollectionFormController {
   public void setTouched(int formid){
       ConcreteUsrUser.setResultForm(formid);
   }
    public void  takeForm(){
       ConcreteUsrUser.setResultForm();
    }
    public String getUserid(){return ConcreteUsrUser.getUsrUser().getUid();}
}
