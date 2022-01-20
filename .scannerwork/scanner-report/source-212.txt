package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.EditProfileController;

import static java.lang.Thread.sleep;

public class UpdateDescrizionePersonaleBean {
    private EditProfileController controller;
    public UpdateDescrizionePersonaleBean (){
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
