package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.HomepageController;

import java.util.Calendar;


public class HomepageBean {
    private HomepageController controller;
    public HomepageBean(){
        controller=new HomepageController();
    }
    public String getUserId() {
        return controller.getUserID();
    }
    public Integer[] getParam(){
        return controller.getParam();
    }
    public String getDescription(){
        return  controller.getDescription();
    }
    public String getTag(){
        WordCheck checkStr=new WordCheck(3,20);
        String tag=controller.getTag();
        tag=checkStr.check1(tag,"\n");
        tag=checkStr.check(tag);
        return tag;
    }
    public String getGoal(){
        WordCheck checkStr=new WordCheck(3,20);
        String goal= controller.getGoal();
        return checkStr.check(goal);
    }
    public Integer[] getData(){
        return controller.getDate();
    }
    public boolean getExpired(){return controller.getExpired();}
}
