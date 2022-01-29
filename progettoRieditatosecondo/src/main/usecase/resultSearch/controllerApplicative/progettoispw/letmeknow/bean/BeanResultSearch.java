package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ResultSearchController;

import java.util.ArrayList;

public class BeanResultSearch {
    Integer nval;
    ResultSearchController controller;
    private ArrayList<InnerUsers> actual;
    public BeanResultSearch(int val){
        nval=val;
        controller=new ResultSearchController(nval);
    }
    public BeanResultSearch(){
        controller=new ResultSearchController();
    }

    public String[][] exitDes(){
        int index;
        String [][] arrStr=new String[3][nval];
        actual=controller.queryUsers();
        for(InnerUsers usr : actual){
            index=actual.indexOf(usr);
            arrStr[0][index]=usr.getUserid();
            arrStr[1][index]=usr.getGoal();
            arrStr[2][index]=usr.getDescription();
            usr.getStatus();
        }
        return arrStr;
    }

    public void touched(String user){
        controller.who(user);
    }
    public int[] getnval(){
        return controller.nVisit();
    }
    public void reset(){
        controller.reset();
    }
}
