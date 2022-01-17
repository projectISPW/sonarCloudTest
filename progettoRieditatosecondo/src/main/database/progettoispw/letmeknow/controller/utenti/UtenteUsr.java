package progettoispw.letmeknow.controller.utenti;

import java.sql.SQLException;
import java.util.Vector;

public class UtenteUsr extends SalvaUtente {
    public UtenteUsr(String who) {
        super(who);
        dataHomeUsr();
        queryResult();
    }
    private int pos;
    private int hum;
    private int emp;
    private String personalDescrip;
    private String obbPersonale;
    private String tag;
    private String data;
    static Goal personalObb=new Goal();
    public void  dataHomeUsr () {
        try{
            rst = userData.getUserData(userid);
            while(rst.next()){
                pos = Integer.parseInt(rst.getString(POS));
                hum = Integer.parseInt(rst.getString(HUM));
                emp= Integer.parseInt(rst.getString(EMP));

                tag=rst.getString(TAG);
                data=rst.getString(END);
                obbPersonale=rst.getString(GOAL);
                personalObb.setObiettivo(obbPersonale);
                personalObb.setTag(tag);
                personalObb.setStrData(data);
                personalDescrip =rst.getString(DES);
                return ;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return ;
        }finally {

        }
    }
    public int getEmp(){
        return emp;
    }
    public int getHum(){
        return hum;
    }
    public int getPos(){
        return pos;
    }
    public String getDescrizione(){

        return personalDescrip;
    }
    public String getTag(){return personalObb.getTag();}
    public String getObiettivo(){

        return personalObb.getObiettivo();
    }
    public Integer[] getData(){return personalObb.getData();}
    public void setPersonalDes(String newS)  {

        personalDescrip=newS;
        userData.setDescription(userid,newS);


    }
    public void setPersonalGoal(String newS)  {
        personalObb.setObiettivo(newS);
        userData.setGoal(userid,newS);

    }
    public void setPersonalTag(String newS)  {
        personalObb.setTag(newS);
        userData.setTag(userid,newS);

    }
    public void setPersonalData(Integer [] value)  {
        personalObb.setData(value);
        userData.setData(userid,personalObb.getDataStr_American());

    }
    public int media(int n1,int n2){
        System.err.println("parametri entrati"+n1+","+n2);
        int val=(int)(n1+n2)/3;
        if(val<1)return 1;
        else if(val>5)return 5;
        return val;
    }
    public void setParams(){
        queryResult();
    }
    public void queryResult() {
        try{
            boolean edited=false;
            rst = userData.getResult(userid);
            char[] about;
            Vector<Integer> calculated=new Vector<Integer>();
            int empMed = 0, humMed = 0, posMed = 0;
            while (rst.next()) {
                edited=true;
                if (rst.getString(CALCULATED).equals("1")) {
                    System.out.println("i am here ");
                    about = rst.getString(ABOUT).toCharArray();
                    for (int i = 0; i < about.length; i++) {
                        System.out.println("valori in entrata valore .:"+rst.getString(START+i));
                        switch (about[i]) {
                            case '1': {
                                empMed += Integer.parseInt(rst.getString(START + i));
                                System.err.println("param i entrata"+empMed);
                                break;
                            }
                            case '2': {
                                humMed += Integer.parseInt(rst.getString(START + i));
                                break;
                            }
                            case '3': {
                                posMed += Integer.parseInt(rst.getString(START + i));
                                break;
                            }
                        }
                    }
                    calculated.add(Integer.parseInt(rst.getString(1)));
                    emp=media(empMed,emp);
                    hum=media(humMed,hum);
                    pos=media(posMed,pos);
                }
            }
            for(Integer id :calculated)userData.setCalculated(userid,id);
            if(edited){
                System.err.println("parametri aggiornati emp"+emp+"hum"+hum+"pos"+pos);
                userData.setParams(userid,new int[]{emp,hum,pos});
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
