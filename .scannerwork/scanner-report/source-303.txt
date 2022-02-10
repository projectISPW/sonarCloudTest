//took out unused libraries

package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.CollectionFormController;
import progettoispw.letmeknow.controller.chat.Message;
import java.util.ArrayList;

public class CollectionFormBean {
    private CollectionFormController controller;
    public CollectionFormBean() {
        controller=new CollectionFormController();
    }
    public void setTouched(int formid){
        if(formid>=1&& formid<=3){
            controller.setTouched(formid);
        }
        else controller.setTouched(1);
    }
    public void takeForm(){
        controller.takeForm();
    }
    public String getUid(){return controller.getUserid();}
}
