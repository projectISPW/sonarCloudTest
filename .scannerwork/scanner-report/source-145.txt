package progettoispw.letmeknow.controller.usruser;

import progettoispw.letmeknow.controller.user.InitialUser;

public class UsrUser extends InitialUser {
    UsrUserDAO userDataUSR;
    private String des;
    private Goal personalObb;
    private ParameterSliders parameterSliders;
    public UsrUser(String who) {
        super(who);
        userDataUSR =new UsrUserDAO();
        personalObb=new Goal();
        parameterSliders=new ParameterSliders();
        dataHomeUsr();
        queryResult();
    }
    public void  dataHomeUsr () {
        if(userid!=null){
            String [] inner= userDataUSR.selectUsrUser(userid);
                parameterSliders.setEmp(inner[0]);
                parameterSliders.setHum(inner[1]);
                parameterSliders.setOpt(inner[2]);
                des = inner[3];
                personalObb.setObiettivo(inner[4]);
                personalObb.setTag(inner[6]);
                personalObb.setStrDataAmericanEurope(inner[5]);
        }
    }

    public int getEmp(){
        return parameterSliders.getEmp();
    }
    public int getHum(){
        return parameterSliders.getHum();
    }
    public int getOpt(){
        return parameterSliders.getOpt();
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
        return personalObb.getDataEuropean();
    }
    public boolean setPersonalDes(String newS)  {
        des =newS;
        return userDataUSR.setDescription(userid,newS);
    }
    public boolean setPersonalGoal(String newS)  {
        personalObb.setObiettivo(newS);
        return userDataUSR.setGoal(userid,newS);
    }
    public boolean setPersonalTag(String newS)  {
        personalObb.setTag(newS);
        return userDataUSR.setTag(userid,newS);
    }
    public boolean setPersonalData(String newData)  {
        personalObb.setStrDataEurope(newData);
        return userDataUSR.setData(userid,personalObb.getAmericanDataStr());
    }
    public void setParams(){
        queryResult();
        dataHomeUsr();
    }
    public boolean getExpired(){
        return personalObb.getExpired();
    }
    public boolean queryResult() {
        return userDataUSR.getResult(userid,parameterSliders.getAll());
    }
}