package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ISCController;

import java.util.ArrayList;
import java.util.Vector;

public class ISCBean {
    private int nval;
    private ISCController controller;
    public ISCBean (int val){
        nval=val;
        controller=new ISCController(nval);
    }
    public ISCBean (){
        nval=0;
        controller=new ISCController();
    }
    int indice;
    private ArrayList<lastMessage> actual;
    public String getUserid(){
        return controller.getUid();
    }
    public String[] exitUid(){
        actual= (ArrayList<lastMessage>) controller.queryUsers();
        System.out.println("grandezza della lista .:"+actual.size());
        String [] arrStr;
        if(nval!=0) arrStr=new String[nval];
        else arrStr=new String [actual.size()];
        for(lastMessage usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.getUserid();
            System.out.println(arrStr[indice]+actual.indexOf(usr));
        }
        return arrStr;
    }
    public String[] exitMsg(){
        String [] arrStr;
        if(nval!=0) arrStr=new String[nval];
        else arrStr=new String [actual.size()];
        for(lastMessage usr : actual){
            indice=actual.indexOf(usr);
            arrStr[indice]=usr.getLastmsg();
        }
        return arrStr;
    }
    public void touched(String user){
        controller.who(user);
    }
    public void search(String find){
        if(!find.equals("")) {controller.search(find);}
    }
    public void reset(){
        controller.reset();
    }
}
