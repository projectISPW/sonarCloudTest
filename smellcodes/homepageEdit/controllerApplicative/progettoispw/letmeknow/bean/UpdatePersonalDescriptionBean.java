package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.EditProfileController;



public class UpdatePersonalDescriptionBean {
    private EditProfileController controller;
    public UpdatePersonalDescriptionBean(){
        controller=new EditProfileController();
    }
    public void entryValue(String Value){
        if(!Value.equals("")){
            if(Value.toCharArray()[0]=='#'){
            try {
                controller.setNewStr(Value);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}}
