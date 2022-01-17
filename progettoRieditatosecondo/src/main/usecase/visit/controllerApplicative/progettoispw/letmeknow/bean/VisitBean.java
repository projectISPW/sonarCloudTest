package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.WordCheck;
import progettoispw.letmeknow.controller.VisitController;

public class VisitBean {
    VisitController controller;
    public String getUserId() {
        controller=new VisitController();
        return controller.getUserid();
    }

    public String exitObiettivo() {
        WordCheck checkStr = new WordCheck(3, 20);
        String obiettivo = controller.tornaObiettivo();
        return obiettivo=checkStr.check(obiettivo);
    }
    public Integer[] exitData(){
            Integer [] data=controller.tornaData();
            return data;
    }

    public Integer [] exitValue(){
        Integer valori []={0,0,0};
        //valori[0]=1;  valori[1]=1; valori[2]=1;
        valori[0]=controller.tornaValoriEmpatia();
        valori[1]=controller.tornaValoriUmorismo();
        valori[2]=controller.tornaValoriPositivita();
        for(int i =0;i<2;i++){
            if(valori[i]>5 || valori[i]<1){
            System.err.println("error occurred");
            }
        }
        return valori;
    }
    public String exitTag(){
            WordCheck checkStr=new WordCheck(3,20);
            String tag=controller.tornaTag();
            return tag;
        }

    public String exitDes(){
        String output= controller.tornaDescrizione();
        return output;
    }
}
