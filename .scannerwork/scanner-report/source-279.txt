package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

public class InnerUsers {
    private final String userid;
    private String description;
    private String goal;
    private int lenMax;
    private WordCheck check=new WordCheck();
    public InnerUsers(UtenteUsr elem){
        lenMax=15;
        userid=elem.getUserid();
        description= elem.getDescript();
        goal=elem.getTag();
    }

    public String getUserid() {
        return userid;
    }

    public String getDescription() {
        return description;
    }

    public String getGoal() {
        return goal;
    }

    public void getStatus(){
        System.out.println("userid"+userid +"description"+description+"tag"+goal);
    }

}
