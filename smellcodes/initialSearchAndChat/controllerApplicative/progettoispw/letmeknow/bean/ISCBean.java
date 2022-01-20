package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.ISCController;

import java.util.ArrayList;


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
    int index;
    private ArrayList<lastMessage> actual;
    public String getUserid(){
        return controller.getUid();
    }
    public String[] exitUid(){
        actual= (ArrayList<lastMessage>) controller.queryUsers();
        System.out.println("list's length .:"+actual.size());
        String [] arrStr;
        if(nval!=0) arrStr=new String[nval];
        else arrStr=new String [actual.size()];
        for(lastMessage usr : actual){
            index =actual.indexOf(usr);
            arrStr[index]=usr.getUserid();
            System.out.println(arrStr[index]+actual.indexOf(usr));
        }
        return arrStr;
    }
    public String[] exitMsg(){
        String [] arrStr;
        if(nval!=0) arrStr=new String[nval];
        else arrStr=new String [actual.size()];
        for(lastMessage usr : actual){
            index =actual.indexOf(usr);
            arrStr[index]=usr.getLastmsg();
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
