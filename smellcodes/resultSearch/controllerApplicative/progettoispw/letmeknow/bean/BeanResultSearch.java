package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ResultSearchController;

import java.util.ArrayList;

public class BeanResultSearch {
    Integer nval;
    ResultSearchController controller;
    public BeanResultSearch(int val){
        nval=val;
        controller=new ResultSearchController(nval);
    }
    public BeanResultSearch(){
        controller=new ResultSearchController(nval);
    }

    int index;
    private ArrayList<InnerUsers> actual;
    public String[] exitDes(){
        String [] arrStr=new String[nval];
        actual=controller.queryUsers();
        for(InnerUsers usr : actual){
            index =actual.indexOf(usr);
            arrStr[index]=usr.get("description");
        }
        return arrStr;
    }
    public String[] exitGoal(){
        String [] arrStr=new String[nval];
        for(InnerUsers usr : actual){
            index =actual.indexOf(usr);
            arrStr[index]=usr.get("goal");
        }
        return arrStr;
    }
    public String[] exitUID(){
        String [] arrStr=new String[nval];
        for(InnerUsers usr : actual){
            index =actual.indexOf(usr);
            arrStr[index]=usr.get("userid");
        }
        return arrStr;
    }
    public void touched(String user){
        controller.who(user);
    }
}
