package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.VisitController;

public class VisitBean {
    VisitController controller;
    public String getUserId() {
        controller=new VisitController();
        return controller.getUserid();
    }

    public String exitGoal() {
        WordCheck checkStr = new WordCheck(3, 20);
        String goal = controller.returnGoal();
        return goal=checkStr.check(goal);
    }
    public Integer[] exitData(){
        Integer [] data=controller.returnDate();
        return data;
    }

    public Integer [] exitValue(){
        Integer values []={0,0,0};
        //values[0]=1;  values[1]=1; values[2]=1;
        values[0]=controller.returnEmpathyValues();
        values[1]=controller.returnHumorValues();
        values[2]=controller.returnOptimismValues();
        for(int i =0;i<2;i++){
            if(values[i]>5 || values[i]<1){
                System.err.println("error occurred");
            }
        }
        return values;
    }
    public String exitTag(){
        WordCheck checkStr=new WordCheck(3,20);
        String tag=controller.returnTag();
        return tag;
    }

    public String exitDes(){
        String output= controller.returnDescription();
        return output;
    }
}
