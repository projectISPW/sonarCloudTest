package progettoispw.letmeknow.controller.psyuser;

import progettoispw.letmeknow.controller.user.InitialUser;

import java.util.List;

public class PsyUser extends InitialUser {
    PsyUserDAO userDataPsy;
    Form form;
    List<Form> listForms;
    float [] selected;
    public PsyUser(String who) {
        super(who);
        form=new Form();
        userDataPsy=new PsyUserDAO();
    }
    public boolean suggestQuestion(String textInput) {
        return userDataPsy.suggestForm(userid,textInput);
    }
    public List<Form> getSum(){
        return form.getSum(listForms);
    }
    public int getCounter(int formid){
        return form.getCounter(listForms,formid);
    }
    public void  collectForms(int month,int year) {
        listForms=userDataPsy.collectForms(month,year);
    }
    public void setSelected(float [] input){
        selected=input;
    }
    public float[] getSelected() {
        return selected;
    }
}
