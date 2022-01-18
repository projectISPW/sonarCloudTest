package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class InnerUsers {
    private final String userid;
    private String description;
    private String goal;
    private int lenMax;
    private WordCheck check=new WordCheck();
    public InnerUsers(UtenteUsr elem){
        lenMax=15;
        userid=elem.getUserid();
        description= elem.getDescrizione();
        goal=elem.getTag();
    }
    public  String get(String what){
        switch(what){
            case "userid" :{
                return userid;
            }
            case "description" :{
                if(description!=null && description.length()>lenMax)description= check.checkLen(description,lenMax);
                return check.checkAhead(description);
            }
            case "goal" :{
                if(goal!=null && goal.length()>lenMax)goal= check.checkLen(goal,lenMax);
                return check.checkAhead(goal);
            }
            default: return null;
        }
    }

    public void getStatus(){
        System.out.println("userid"+userid +"descrizione"+description+"tag"+goal);
    }

}
