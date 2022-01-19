package progettoispw.letmeknow.controller.utentiusr;

import progettoispw.letmeknow.controller.utenti.SalvaUtente;

public class UtenteUsr extends SalvaUtente {
    UserDAO userData;
    private int pos;
    private int hum;
    private int emp;
    private String des;
    private String goal;
    private String tag;
    private String data;
    static Goal personalObb;
    public UtenteUsr(String who) {
        super(who);
        userData=new UserDAO();
        personalObb=new Goal();
        dataHomeUsr();
        queryResult();
    }

    public void  dataHomeUsr () {
        String [] inner=userData.selectUser(userid);
        emp= Integer.parseInt(inner[0]);
        hum = Integer.parseInt(inner[1]);
        pos = Integer.parseInt(inner[2]);
        des =inner[3];
        goal =inner[4];
        data=inner[5];
        tag=inner[6];
        personalObb.setObiettivo(goal);
        personalObb.setTag(tag);
        personalObb.setStrData(data);
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
        return des;
    }
    public String getTag(){
        return personalObb.getTag();
    }
    public String getObiettivo(){
        return personalObb.getObiettivo();
    }
    public Integer[] getData(){
        return personalObb.getData();
    }
    public void setPersonalDes(String newS)  {
        des =newS;
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
    public void setParams(){
        queryResult();
        dataHomeUsr();
    }
    public boolean queryResult() {
       return userData.getResult(userid,emp,hum,pos);
    }
}
