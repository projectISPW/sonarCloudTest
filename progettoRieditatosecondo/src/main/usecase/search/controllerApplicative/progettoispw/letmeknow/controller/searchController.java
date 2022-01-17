package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.utenti.UtenteUsr;

public class searchController {
    private ControllerClass factory;
    private Search find;
    public searchController(){
        factory=new ControllerClass();
        if(factory.getSearch()==null)factory.controllerUsers();
        find= factory.getSearch();
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
        UtenteUsr me =factory.getUserUSR();
        enterAffinity(0);
        enterGoal(me.getTag());
        enterParamSearch(new  Integer[] {me.getEmp(),me.getHum(),me.getPos()} );
    }
}
