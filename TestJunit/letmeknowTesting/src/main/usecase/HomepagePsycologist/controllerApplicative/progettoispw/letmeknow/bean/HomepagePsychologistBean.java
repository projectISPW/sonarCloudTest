package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.HomepagePsychologistController;


import java.time.LocalDate;

public class HomepagePsychologistBean {
    HomepagePsychologistController controller;
    int month;
    int year;
    String [] monthNames;
    public HomepagePsychologistBean(){
        LocalDate currentdate = LocalDate.now();
        month=currentdate.getMonthValue();
        year=currentdate.getYear();
        monthNames = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        controller=new HomepagePsychologistController();
        controller.getLists(month,year);
    }
    public String getMonth(){
        return monthNames[month-1];
    }
    public void decremMonth(){
        if(month==1){
            month=12;
            year--;
        }
        else{
            month-=1;
        }
        controller.getLists(month,year);
    }
    public void incremMonth(){
        if(month==12){
            month=1;
            year++;
        }else{
            month+=1;
        }
        controller.getLists(month,year);
    }
    public float  getForms(){
        float[] ret=controller.getList();
        if(ret.length==0)return 0;
        return ret[0];
    }
    public void setSelected(int selected) {
        controller.setSelected(selected);
    }
    public boolean suggestForm(String input){
        if(!input.equals(""))return controller.setFeed(input);
        return false;
    }
}
