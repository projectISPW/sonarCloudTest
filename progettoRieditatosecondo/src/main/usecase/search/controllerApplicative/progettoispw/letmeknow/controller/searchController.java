package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.utentiusr.UtenteUsr;

public class SearchController {
    private Search find;
    public SearchController(){
        ControllerClass.setSearch();
        find=ControllerClass.getSearch();
    }
    public void enterAffinity(Integer input){
        find.setAffinity(input);
    }
    public void enterGoal(String input){
        find.goalSearch(input);
    }
    public void enterDes(String input){
        find.descrSearch(input);
    }
    public void enterParamSearch(Integer [] input ){
        find.parametricSetSearch(input);
    }
    public void toMe(){
        UtenteUsr me =ControllerClass.getUserUSR();
        enterAffinity(0);
        if(me.getTag()!=null)enterGoal(me.getTag());
        enterDes(me.getDescript());
        enterParamSearch(new  Integer[] {me.getEmp(),me.getHum(),me.getOpt()} );
    }
}
