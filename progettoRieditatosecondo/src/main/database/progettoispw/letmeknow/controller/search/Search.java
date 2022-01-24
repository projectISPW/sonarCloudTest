package progettoispw.letmeknow.controller.search;

import progettoispw.letmeknow.controller.utenti.SalvaUtenteMeta;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Search {
    private String userid;
    private SearchDAO searchData;
    private Sliders slider;
    private ArrayList<String> foundList;
    private UtenteUsr touched;
    public Search(String who) {
        foundList= new ArrayList <String>();
        searchData=new SearchDAO();
        userid=who;
    }
    public void setAffinity(Integer val) {
        slider = new Sliders(val);
    }
    public void parametricSetSearch(Integer [] val) {
        slider.setEmp(val[0]);
        slider.setHum(val[1]);
        slider.setPos(val[2]);
        parametricSearch();
    }
    public void parametricSearch() {
        Integer[] array = slider.getAll();
        ArrayList<String> inner= (ArrayList<String>) searchData.paramSearch(userid, array[0], array[1], array[2]);
        foundList.addAll(inner);
    }
    public void goalSearch(String goal) {
        ArrayList<String>inner= (ArrayList<String>) searchData.paramSearch(userid, 1, 1, 1);
        for(String elem:inner){
            UtenteUsr user=new UtenteUsr(elem);
            if(user.getTag().contains(goal)){
                foundList.add(elem);
            }
        }
    }
    public void descrSearch(String descr) {
        ArrayList<String> inner= (ArrayList<String>) searchData.paramSearch(userid, 1, 1, 1);
        for(String elem:inner){
            UtenteUsr user=new UtenteUsr(elem);
            if(user.getDescript().contains(descr)){
                foundList.add(elem);
            }
        }
    }
    public ArrayList<String> getArrayList(){
        ArrayList inner=new ArrayList();
        if(foundList.isEmpty()){
            inner=searchData.getVisit(userid);
        }
        for(String str:foundList){
            if(!inner.contains(str))inner.add(str);
        }
        return inner;
    }
    public boolean setTouched(String userid2) {
        boolean bool;
        bool=searchData.addVisited(userid,userid2);
        this.touched = new UtenteUsr(userid2);
        return bool;
    }
    public int[] getnVisit(){
        int [] inner;
        inner=searchData.getnVisit(userid);
        return inner;
    }
    public UtenteUsr getTouched() {
        return touched;
    }
}

