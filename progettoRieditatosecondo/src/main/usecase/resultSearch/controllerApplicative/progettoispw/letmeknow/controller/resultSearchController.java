package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.innerUsers;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

import java.util.Vector;

public class resultSearchController {
    ControllerClass factory;
    private Vector<UtenteUsr> founded;
    private Integer count;
    private Integer nVal;
    public resultSearchController(Integer n){
        factory=new ControllerClass();
        founded=factory.getSearch().getVector() ;
        nVal=n;
        count=0;
    }
    Vector<innerUsers>formatted;
    public void attach(innerUsers elem){
        formatted.add(elem);
        //elem.getStatus();
    }
    innerUsers actual;
    public Vector<innerUsers> queryUsers(){
        int indice;
        actual=null;
        formatted=new Vector<>();
        count = check(count);
        for (UtenteUsr usr : founded) {
            indice = founded.indexOf(usr);
            if (indice >= count && indice < count + nVal) {
               UtenteUsr nusr = new UtenteUsr(usr.getUserid());
               actual = new innerUsers(nusr);
               //System.out.println(usr.getUserid()+"nel controller");
                actual.getStatus();
                attach(actual);
            }
        }
        count+=nVal;
        return formatted;
    }

    private Integer check(Integer count) {
        if(count>=founded.toArray().length){
            return count=0;
        }
        return count;
    }
    public void who(String usr){
        factory.getSearch().setTouched(usr);
    }
}
