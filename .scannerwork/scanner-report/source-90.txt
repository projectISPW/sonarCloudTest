package progettoispw.letmeknow.controller.utenti;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SalvaUtente implements SalvaUtenteMeta {
    protected String userid;
    private String password;
    private String type;
    private String email;
    protected UtenteSQL userData;
    protected ResultSet rst;
    private final static Lock mutex = new ReentrantLock(true);
    private boolean bool;
    public SalvaUtente(String who)  {
        try {
            bool=false;
            userData = new UtenteSQL();
            rst = userData.getUserData(who);
            while(rst.next()){
                userid = rst.getString(USERID);
                password=rst.getString(PASSWORD);
                type=rst.getString(TYPE);
                email=rst.getString(EMAIL);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public SalvaUtente(){
        userid=password=type=null;
    }
    public boolean checkUtente (String pswdInput){
        return password.equals(pswdInput);
    }
    public String abscessType (String pswdInput) {
        if (checkUtente(pswdInput)) {
            if(type.equals("usr")) {
                return "usr";
            }
            else if (type.equals("psy")){
                return "psy";
            }
            else {
                System.err.println("password errata");
                return "uncorrect log " ;
            }
        }
        System.err.println("errore nel tipo di dato ");
        return "uncorrect log ";
    }
    public String getType() {
        return type;
    }
    public String getUserid(){
        return userid;
    }
    public boolean setPassword(String input){
        if(userData.setPswd(userid,input)){
            return sendMail(email);
        }
        return false;
    }
    public boolean  checkEmail(String input){
        userData=new UtenteSQL();
        return userData.checkEmail(input);
    }
    public boolean setEmail(String input){
        if(userData.setEmail(userid,input)){
            email=input;
            if(sendMail(email)){
                return true;
            }
        }
        return false;
    }
    public boolean sendMail(String to) {
        try{
            userData = new UtenteSQL();
            String []data =userData.recover(to);
            if(data!=null){
                 JavaMailUtil email=new JavaMailUtil();
                 String text="Your userid is .:     "+data[0]+"\nYour password is .:        "+data[1];
                 email.setText(text);
                 if(email.sendMail(to)==false)return false;
                 return true;
             }
        return false  ;
        } catch (Exception e) {
            return false;
        }
    }
    private String getUid(){
        int Random;
        int min=1000000;
        int max=9999999;
        String check=null;
        boolean different=true;
        mutex.lock();
        Vector<String>uidList=userData.getUID();
        if(uidList==null)return "0000000";
        while(different==true){
            Random= (int) (Math.random()*(max-min)) + min;
            different=false;
            check=""+Random;
            for(String uid : uidList){
                if(check.equals(uid)){
                    different=true;
                }
            }
        }
        mutex.unlock();
        return check;
    }
    public boolean registrationUSR(String password,String email,String type,int [] val,String description,String goal)  {
            String uid=getUid();
            bool= userData.registration(uid,password,type,val,description,email,goal);
            sendMail(email);
            return bool;
    }
    public boolean registrationPSY(String password, String email, String type) {
        String uid=getUid();
        bool= userData.registration(uid,password,type,email);
        if(bool)return sendMail(email);
        return false;
    }
    public boolean setFeed(String feed){
        return userData.feed(userid,feed);
    }

}