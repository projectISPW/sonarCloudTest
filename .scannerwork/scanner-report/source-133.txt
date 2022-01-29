package progettoispw.letmeknow.controller.utentipsy;

import progettoispw.letmeknow.controller.form.FormMeta;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;

import java.util.ArrayList;
import java.util.List;

public class UtentePsy extends SalvaUtente implements FormMeta {
    UserDAO userDataPsy;
    Form form;
    ArrayList<Form> listForms;
    float [] selected;
    public UtentePsy(String who) {
        super(who);
        form=new Form();
        userDataPsy=new UserDAO();
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
