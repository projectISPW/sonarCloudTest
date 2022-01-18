package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.InnerUsers;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

import java.util.ArrayList;
import java.util.Vector;

public class ResultSearchController {
    ControllerClass factory;
    private final ArrayList<String> founded;
    private Integer count;
    private final Integer nVal;
    public ResultSearchController(Integer n){
        founded=ControllerClass.getSearch().getArrayList() ;
        nVal=n;
        count=0;
    }
    ArrayList<InnerUsers>formatted;
    public void attach(InnerUsers elem){
        formatted.add(elem);
    }
    InnerUsers actual;
    public ArrayList<InnerUsers> queryUsers(){
        int indice;
        actual=null;
        formatted=new ArrayList<>();
        count = check(count);
        UtenteUsr user;
        for (String userid : founded) {
            user=new UtenteUsr(userid);
            indice = founded.indexOf(userid);
            if (indice >= count && indice < count + nVal) {
               actual = new InnerUsers(user);
               actual.getStatus();
               attach(actual);
            }
        }
        count+=nVal;
        return formatted;
    }

    private Integer check(Integer count) {
        if(count>=founded.size()){
            return count=0;
        }
        return count;
    }
    public void who(String usr){
        factory.getSearch().setTouched(usr);
    }
}
