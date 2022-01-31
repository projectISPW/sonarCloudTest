package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.HomepageEditController;

import java.util.Calendar;
import java.util.stream.IntStream;

public class HomepageEditBean {
    private HomepageEditController controller;
    public HomepageEditBean() {
        controller=new HomepageEditController();
    }
    public String getUserid() {
        return controller.getUserID();
    }
    public boolean setDescription(String input){
        if(!input.equals("")){
            if(input.toCharArray()[0]=='#'){
                return controller.setDes(input);
            }
            return false;
        }
        return true;
    }
    public boolean setTag(String input){
        if(!input.equals("")){
            if(input.toCharArray()[0]=='#'){
                return controller.setTag(input);
            }
            return false;
        }
        return true;
    }
    public boolean setGoal(String input){
        if(!input.equals("")){
           return controller.setGoal(input);
        }
        return true;
    }
    public boolean setDate(String input){
        if(!input.equals("") ){
            int count=0;
            for(char elem:input.toCharArray())if(elem=='-')++count;

            if(count!=2){
                return false;
            }
            return controller.setDate(input);
        }
        return true;
    }


}
