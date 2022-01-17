package progettoispw.letmeknow.controller.utentiPsy;

import progettoispw.letmeknow.controller.form.FormMeta;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;

import java.sql.SQLException;
import java.util.Vector;

public class UtentePsy extends SalvaUtente implements FormMeta {
    UtenteSQL userDataPsy;
    Form form;
    Vector<Form>listForms;
    float [] selected;
    public UtentePsy(String who) {
        super(who);
        userDataPsy=new UtenteSQL();
        form=new Form();
    }
    public boolean suggestQuestion(String textInput) {
        return userDataPsy.suggestForm(userid,textInput);
    }
    public Vector<Form> getSum(){
        return form.getSum(listForms);
    }
    public int getCounter(int formid){
        return form.getCounter(listForms,formid);
    }
    public void  collectForms(int month,int year) {
        try {
            listForms = new Vector<>();
            int[] answers;
            rst = userDataPsy.selectResult(month, year);
            while (rst.next()) {
                answers = new int[6];
                for (int i = 0; i < 6; i++) {
                    answers[i] = Integer.parseInt(rst.getString(START + i));
                }
                listForms = form.attach(Integer.parseInt(rst.getString(FORMID)), answers,rst.getString(2), listForms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public void setSelected(float input[]){
        System.out.println("nel controller");
        selected=input;}

    public float[] getSelected() {
        return selected;
    }
}
