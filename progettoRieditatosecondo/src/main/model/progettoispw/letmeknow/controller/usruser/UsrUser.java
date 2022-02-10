package progettoispw.letmeknow.controller.usruser;

import progettoispw.letmeknow.controller.User;
import progettoispw.letmeknow.controller.user.UserDAO;

public class UsrUser implements User {
    UsrUserDAO userDataUSR;
    private String uid;
    private String des;
    private Goal personalObb;
    private ParameterSliders parameterSliders;
    public UsrUser(String who) {
        uid =who;
        userDataUSR =new UsrUserDAO();
        personalObb=new Goal();
        parameterSliders=new ParameterSliders();
        dataHomeUsr();
        queryResult();
    }
    @Override
    public String getUserid() {
        return uid;
    }
    @Override
    public String getType() {
        return "usr";
    }
    @Override
    public boolean confirmCredentials(String password) {
        UserDAO innerDao=new UserDAO();
        return password.equals(innerDao.getPswd(uid));
    }
    public void  dataHomeUsr () {
        if(uid !=null){
            String [] inner= userDataUSR.selectUsrUser(uid);
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
    public int[] getDate(){
        return personalObb.getDataEuropean();
    }
    public boolean setPersonalDes(String newS)  {
        des =newS;
        return userDataUSR.setDescription(uid,newS);
    }
    public boolean setPersonalGoal(String newS)  {
        personalObb.setObiettivo(newS);
        return userDataUSR.setGoal(uid,newS);
    }
    public boolean setPersonalTag(String newS)  {
        personalObb.setTag(newS);
        return userDataUSR.setTag(uid,newS);
    }
    public boolean setPersonalData(String newData)  {
        personalObb.setStrDataEurope(newData);
        return userDataUSR.setData(uid,personalObb.getAmericanDataStr());
    }
    public void setParams(){
        queryResult();
        dataHomeUsr();
    }
    public boolean getExpired(){
        return personalObb.getExpired();
    }
    public boolean queryResult() {
        return userDataUSR.getResult(uid,parameterSliders.getAll());
    }


}