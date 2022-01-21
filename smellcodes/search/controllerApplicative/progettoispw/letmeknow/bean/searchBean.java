package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.*;

public class searchBean {
    private searchController controller;
    public searchBean(){
        controller=new searchController();
    }
    public void enterParamSearch(Integer [] input){
        if(input[0]>=1 || input[1]>=1 || input [2]>=1){
            controller.enterParamSearch(input);
        }
    }
    public void enterGoalSearch(String input){
        controller.enterGoal(input);
    }
    public void enterDescrSearch(String input){controller.enterDes(input);}
    public void enterAffinity(Integer input) {controller.enterAffinity(input);}
    public void toMe(){
        controller.toMe();
    }
}
