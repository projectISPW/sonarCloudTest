package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.HomepagePsicologistController;

import java.util.Calendar;
import java.time.LocalDate;
import java.time.Month;
public class HomepagePsicologistBean {
    HomepagePsicologistController controller;
    int month;
    int year;
    String [] monthNames;
    public HomepagePsicologistBean(){
        LocalDate currentdate = LocalDate.now();
        month=currentdate.getMonthValue();
        year=currentdate.getYear();
        monthNames = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        controller=new HomepagePsicologistController();
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
    public float [] getForms(){
        System.out.println("mese corrente "+month+"anno corrente"+year);
        float[] ret=controller.getList();
        if(ret==null)return new float[1];
        return ret;
    }
    public void setSelected(int selected) {
       controller.setSelected(selected);
    }
    public boolean suggestForm(String input){
        if(!input.equals(""))return controller.setFeed(input);
        return false;
    }
}
