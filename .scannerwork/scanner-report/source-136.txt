package progettoispw.letmeknow.controller.utentipsy;

import progettoispw.letmeknow.controller.form.FormMeta;

import java.util.ArrayList;

public class Form implements FormMeta {
    int formid;
    String userid;
    int [] answers;
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
        System.out.println("ciao il mio form è pari a .: "+formid+"il mio id è "+userid+"le mie risposte in input sono .:");
        for(int i=0;i<answers.length;i++){System.out.println(answers[i]);}
    }
    public void getStatus(ArrayList<Form>forms){
        for(Form elem :forms)elem.getStatus();
        System.out.println("________________________________________________________________");
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
        System.out.println("i am here ");
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
            System.err.println(val);
            in=false;
            for (int i : ids) if (val == i) in = true;
            System.out.println(elem.getUserid());
            if (in) {
                System.out.println("i am discard with val "+val);
                form = getElem(inner,val);
                System.out.println("*****************************************");
                form.getStatus();
                System.out.println("*****************************************");
                answersCompare = form.getAnswers();
                for (int i = 0; i < answers.length; i++) {
                    answers[i] += answersCompare[i];
                }
                form.setAnswers(answers);
            } else {
                System.out.println("i am insert with val "+val);
                inner = attach(val, answers,id, inner);
                ids[val-1]=val;
            }
        }
        getStatus(inner);
        return inner;
    }
}
