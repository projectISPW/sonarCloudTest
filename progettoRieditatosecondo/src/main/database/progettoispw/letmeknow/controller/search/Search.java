package progettoispw.letmeknow.controller.search;

import progettoispw.letmeknow.controller.utenti.SalvaUtenteMeta;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Search implements SalvaUtenteMeta {
    private String userid;
    private SearchSQL searchData;
    private ResultSet rst;
    private Sliders slider;
    private Vector<UtenteUsr> foundList;
    private UtenteUsr touched;
    public Search(String who) {
        try {
            foundList= new Vector <UtenteUsr>();
            searchData = new SearchSQL();
            rst = searchData.getUserData1(who);
            while (rst.next()) {
                userid = rst.getString(USERID);
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.err.println("exeption occurred 1");
        }
    }

    public void setAffinity(Integer val) {
        slider = new Sliders(val);
        return;
    }

    public void parametricSetSearch(Integer [] val) {
        slider.setEmp(val[0]);
        slider.setHum(val[1]);
        slider.setPos(val[2]);
        parametricSearch();
    }


    private void attach(UtenteUsr elem){
        boolean present=false;
       for(UtenteUsr usr :foundList){
           if(usr.getUserid().equals(elem.getUserid()))present=true;
       }
        if(present==false)foundList.add(elem);
    }
    public boolean parametricSearch() {
        try {
            Integer[] array = slider.getAll();
            rst = searchData.search4All(userid, array[0], array[1], array[2]);
           // System.out.println("parametric search");
            while (rst.next()) {
                String usr = rst.getString(USERID);
                System.out.println(usr);
                attach(new UtenteUsr(usr));
            }
            return true;
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.err.println("ho trovato solo questi utenti forse avrei dovuto trovarne altri");
        }
        return false;
    }
    public boolean goalSearch(String goal) {
        try {
            rst = searchData.searchGoal(userid,goal);
            //System.out.println("goal search");
            while (rst.next()) {
                String usr = rst.getString(USERID);
                System.out.println(usr);
                attach(new UtenteUsr(usr));
            }
            return true;
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.err.println("ho trovato solo questi utenti forse avrei dovuto trovarne altri");
        }
        return false;
    }
    public boolean descrSearch(String descr) {
        try {
            rst = searchData.searchDescr(userid,descr);
            System.out.println("description search");
            while (rst.next()) {
                String usr = rst.getString(USERID);
                System.out.println(usr);
                attach(new UtenteUsr(usr));
            }
            return true;
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.err.println("ho trovato solo questi utenti forse avrei dovuto trovarne altri");
        }
        return false;
    }
    public Vector<UtenteUsr> getVector(){
        return foundList;
    }

    public void setTouched(String uid) {
        System.out.println("utente cliccato" +uid);
        this.touched = new UtenteUsr(uid);
    }

    public UtenteUsr getTouched() {
        return touched;
    }
}

