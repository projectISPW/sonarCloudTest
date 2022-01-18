package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.UtenteUsr;
public class HomepageController {
    UtenteUsr user;
    public HomepageController(){
        user= ControllerClass.getUserUSR();
    }
    public String getUserID(){
        return user.getUserid();
    }
    public int tornaValoriEmpatia(){
        System.out.println("nella bean "+user.getEmp());
        return user.getEmp();
    }
    public int tornaValoriUmorismo(){
        return user.getHum();
    }
    public int tornaValoriPositivita(){
        return user.getPos();
    }
    public String tornaObiettivo(){
        return user.getObiettivo();
    }
    public Integer[] tornaData(){
        return user.getData();
    }
    public String tornaTag(){
        return user.getTag();
    }
    public String tornaDescrizione(){
        return user.getDescrizione();
    }
}
