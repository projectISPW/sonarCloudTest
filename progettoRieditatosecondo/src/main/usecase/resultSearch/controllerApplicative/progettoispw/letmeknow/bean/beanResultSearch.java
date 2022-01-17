package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.resultSearchController;

import java.util.Vector;

public class beanResultSearch {
    Integer nval;
    resultSearchController controller;
    public beanResultSearch(int val){
        nval=val;
        controller=new resultSearchController(nval);
    }
    public beanResultSearch(){
        controller=new resultSearchController(nval);
    }

    int indice;
    private Vector<innerUsers> actual;
    public String[] exitDes(){
        String [] arrStr=new String[nval];
        actual=controller.queryUsers();;
        for(innerUsers usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.get("description");
            //System.out.println("About me: in bean " +arrStr[indice]);
        }
        return arrStr;
    }
    public String[] exitGoal(){
        String [] arrStr=new String[nval];
        for(innerUsers usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.get("goal");
        }
        return arrStr;
    }
    public String[] exitUID(){
        String [] arrStr=new String[nval];
        for(innerUsers usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.get("userid");
        }
        return arrStr;
    }
    public void touched(String user){
        controller.who(user);
    }
}
