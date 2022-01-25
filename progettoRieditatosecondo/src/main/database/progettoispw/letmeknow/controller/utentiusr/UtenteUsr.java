package progettoispw.letmeknow.controller.utentiusr;

import progettoispw.letmeknow.controller.utenti.SalvaUtente;

public class UtenteUsr extends SalvaUtente {
    UserDAO userDataUSR;
    private int pos;
    private int hum;
    private int emp;
    private String des;
    private String goal;
    private String tag;
    private String data;
    private Goal personalObb;
    public UtenteUsr(String who) {
        super(who);
        userDataUSR =new UserDAO();
        personalObb=new Goal();
        dataHomeUsr();
        queryResult();
    }
    public void  dataHomeUsr () {
        if(userid!=null){
            String [] inner= userDataUSR.selectUser(userid);
            if(inner[0]!=null && inner[1]!=null && inner[2]!=null) {
                emp = Integer.parseInt(inner[0]);
                hum = Integer.parseInt(inner[1]);
                pos = Integer.parseInt(inner[2]);
                des = inner[3];
                goal = inner[4];
                data = inner[5];
                tag = inner[6];
                personalObb.setObiettivo(goal);
                personalObb.setTag(tag);
                personalObb.setStrData(data);
            }}
       else{
            emp=hum=pos=1;
            goal=tag="";
            data="0-0-0";
        }
    }
    public int getEmp(){
        return emp;
    }
    public int getHum(){
        return hum;
    }
    public int getOpt(){
        return pos;
    }
    public String getDescript(){
        return des;
    }
    public String getTag(){
        return personalObb.getTag();
    }
    public String getGoal(){
        return personalObb.getObiettivo();
    }
    public Integer[] getDate(){
        return personalObb.getData();
    }
    public void setPersonalDes(String newS)  {
        des =newS;
        userDataUSR.setDescription(userid,newS);
    }
    public void setPersonalGoal(String newS)  {
        personalObb.setObiettivo(newS);
        userDataUSR.setGoal(userid,newS);
    }
    public void setPersonalTag(String newS)  {
        personalObb.setTag(newS);
        userDataUSR.setTag(userid,newS);
    }
    public void setPersonalData(Integer [] value)  {
        personalObb.setData(value);
        userDataUSR.setData(userid,personalObb.getDataStr());
    }
    public void setParams(){
        queryResult();
        dataHomeUsr();
    }
    public boolean queryResult() {
        return userDataUSR.getResult(userid,emp,hum,pos);
    }
}