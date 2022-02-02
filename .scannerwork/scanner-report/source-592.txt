package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.psyuser.Form;
import progettoispw.letmeknow.controller.psyuser.PsyUser;

import java.util.List;

public class HomepagePsychologistController {
    private PsyUser user;
    private float [][] innerList;
    private int index;
    static final Integer [] FORMSID={1,2,3};
    public HomepagePsychologistController(){
        user= ControllerClass.getUserPsy();
        innerList=null;
    }
    public float[] getList(){
        if(index<FORMSID.length){
            return innerList[index++];
        }else {
            index=0;
            return new float[0];
        }
    }
    public void getLists(int month , int year){
        index=0;
        user.collectForms(month,year);
        List<Form>list=user.getSum();
        int [] answers;
        int formid;
        int counter;
        innerList= new float[FORMSID.length][7];
        for(Form elem:list){
            formid=elem.getFormid();
            counter=user.getCounter(formid);
            innerList[formid-1][0]=counter;
            answers= elem.getAnswers();
            for(int i=1;i<7;i++){
                innerList[formid-1][i]=(float)answers[i-1]/counter;
            }
        }

    }
    public void setSelected(int selectedInp){
        user.setSelected(innerList[selectedInp-1]);
    }
    public boolean setFeed(String input){
        return user.suggestQuestion(input);
    }
}
