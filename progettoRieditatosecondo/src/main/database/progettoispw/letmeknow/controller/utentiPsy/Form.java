package progettoispw.letmeknow.controller.utentipsy;

import java.util.ArrayList;

public class Form {
    int formid;
    String userid;
    int [] answers;
    static final Integer [] FORMSID={1,2,3};
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUserid() {
        return userid;
    }
    public void setFormid(int formid) {
        this.formid = formid;
    }
    public void setAnswers(int[] answersInp) {
        answers = answersInp;
    }
    public int getFormid() {
        return formid;
    }
    public int[] getAnswers() {
        return answers;
    }
    public void getStatus(){
        for(int i=0;i<answers.length;i++){System.out.println(answers[i]);}
    }
    public void getStatus(ArrayList<Form>forms){
        for(Form elem :forms)elem.getStatus();
    }
    public ArrayList<Form> attach(int formid, int [] answers, String userid, ArrayList<Form> actual){
        if(actual==null)actual=new ArrayList<>();
        Form elem=new Form();
        elem.setFormid(formid);
        elem.setAnswers(answers);
        elem.setUserid(userid);
        actual.add(elem);
        return actual;
    }
    public int getCounter(ArrayList<Form> input, int id){
        int counter=0;
        for(Form elem: input)if (elem.getFormid()==id)counter++;
        return counter;
    }
    public Form getElem(ArrayList<Form> input, int val){
        for(Form elem:input)if(elem.getFormid()==val)return elem;
        return null;
    }

    public ArrayList<Form> getSum(ArrayList<Form> input) {
        int[] ids = new int[FORMSID.length];
        int[] answers;
        int[] answersCompare;
        ArrayList<Form> inner = new ArrayList<>();
        Form form;
        Boolean in ;
        int val;
        String id;
        getStatus(input);
        for (Form elem : input) {
            val = elem.getFormid();
            id=elem.getUserid();
            answers = elem.getAnswers();
            in=false;
            for (int i : ids) if (val == i) in = true;
            if (in) {
                form = getElem(inner,val);
                form.getStatus();
                answersCompare = form.getAnswers();
                for (int i = 0; i < answers.length; i++) {
                    answers[i] += answersCompare[i];
                }
                form.setAnswers(answers);
            } else {
                inner = attach(val, answers,id, inner);
                ids[val-1]=val;
            }
        }
        getStatus(inner);
        return inner;
    }
}
