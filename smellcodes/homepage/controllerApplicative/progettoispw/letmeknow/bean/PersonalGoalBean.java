package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.HomepageController;

import java.util.Calendar;


public class PersonalGoalBean {
    private HomepageController controller;
    public PersonalGoalBean(){
        controller=new HomepageController();
    }
    public String exitGoal(){
        WordCheck checkStr=new WordCheck(3,20);
        String goal= controller.returnGoal();
        //System.out.println("nel bean dell homepage:"+goal);
        if(checkStr.checkString(goal)==false){
             System.err.println("label could go out ");
        }
        return goal=checkStr.check(goal);
    }public Integer[] exitData(){
        //possibile controllo con la data giornaliera
        Integer [] data=controller.returnDate();
        //if(data.getYear()<Calendar.YEAR){
        if(data[2]<Calendar.getInstance().get(Calendar.YEAR)){
            System.err.println("Goal expired for more than a year, update your goal");
        }
        if(data[1]>Calendar.getInstance().get(Calendar.MONTH) && data[2]==Calendar.getInstance().get(Calendar.YEAR)){
            System.err.println("Goal expired for more than a month, update your goal");
        }
        return data;
    }public String exitTag(){
        WordCheck checkStr=new WordCheck(3,20);
        String tag=controller.returnTag();
        tag=checkStr.check1(tag,"\n");
        tag=checkStr.check(tag);
        return tag;
    }
}
