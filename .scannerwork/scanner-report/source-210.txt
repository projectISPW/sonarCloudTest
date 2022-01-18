package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.HomepageController;

import java.util.Calendar;


public class ObiettivoPersonaleBean {
    private HomepageController controller;
    public ObiettivoPersonaleBean (){
        controller=new HomepageController();
    }
    public String exitObiettivo(){
        WordCheck checkStr=new WordCheck(3,20);
        String obiettivo= controller.tornaObiettivo();
        //System.out.println("nel bean dell homepage:"+obiettivo);
        if(checkStr.checkString(obiettivo)==false){
             System.err.println("è possibile che vada fuori la label ");
        }
        return obiettivo=checkStr.check(obiettivo);
    }public Integer[] exitData(){
        //possibile controllo con la data giornaliera
        Integer [] data=controller.tornaData();
        //if(data.getYear()<Calendar.YEAR){
        if(data[2]<Calendar.getInstance().get(Calendar.YEAR)){
            System.err.println("Obiettivo scaduto, da piu di un anno, aggiorna il tuo obiettivo ");
        }
        if(data[1]>Calendar.getInstance().get(Calendar.MONTH) && data[2]==Calendar.getInstance().get(Calendar.YEAR)){
            System.err.println("Obiettivo scaduto, da piu di un mese, aggiorna il tuo obiettivo");
        }
        return data;
    }public String exitTag(){
        WordCheck checkStr=new WordCheck(3,20);
        String tag=controller.tornaTag();
        tag=checkStr.check1(tag,"\n");
        tag=checkStr.check(tag);
        return tag;
    }
}
