package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.bean.InnerUsers;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

import java.util.ArrayList;

public class ResultSearchController {
    ControllerClass factory;
    private final ArrayList<String> founded;
    ArrayList<InnerUsers>formatted;
    private Integer count;
    private final Integer nVal;
    public ResultSearchController(Integer n){
        founded=ControllerClass.getSearch().getArrayList() ;
        for(String usr:founded)System.out.println(founded);
        nVal=n;
        count=0;
    }

    public void attach(InnerUsers elem){
        formatted.add(elem);
    }
    InnerUsers actual;
    public ArrayList<InnerUsers> queryUsers(){
        int index;
        actual=null;
        formatted=new ArrayList<>();
        count = check(count);
        UtenteUsr user;
        for (String userid : founded) {
            user=new UtenteUsr(userid);
            index = founded.indexOf(userid);
            if (index >= count && index < count + nVal) {
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
