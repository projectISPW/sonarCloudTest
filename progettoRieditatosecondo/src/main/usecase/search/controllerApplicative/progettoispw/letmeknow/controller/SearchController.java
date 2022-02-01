package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.search.Search;
import progettoispw.letmeknow.controller.usruser.UsrUser;

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
        UsrUser me =ControllerClass.getUserUSR();
        enterAffinity(0);
        enterGoal(me.getTag());
        enterParamSearch(new  Integer[] {me.getEmp(),me.getHum(),me.getOpt()} );
    }
    public void reset(){
        find.reset();
    }
}
