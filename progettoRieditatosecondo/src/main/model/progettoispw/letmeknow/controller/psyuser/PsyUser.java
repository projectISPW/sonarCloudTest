package progettoispw.letmeknow.controller.psyuser;
import progettoispw.letmeknow.controller.User;
import progettoispw.letmeknow.controller.user.UserDAO;

import java.util.List;

public class PsyUser implements User {
    PsyUserDAO userDataPsy;
    Form form;
    List<Form> listForms;
    float [] selected;
    String userid;
    public PsyUser(String who) {
        userid=who;
        form=new Form();
        userDataPsy=new PsyUserDAO();
    }
    public String getUid() {
        return userid;
    }
    @Override
    public String getType() {
        return "psy";
    }
    @Override
    public boolean confirmCredentials(String password) {
        UserDAO inner=new UserDAO();
        return password.equals(inner.getPswd(userid));
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
