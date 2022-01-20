package progettoispw.letmeknow.controller.utenti;

import progettoispw.letmeknow.controller.utentiusr.UtenteSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SalvaUtente implements SalvaUtenteMeta {
    protected String userid;
    private String password;
    private String type;
    private String email;
    private UserDAO userData;
    protected ResultSet rst;
    private Random randomno ;
    private static final  Lock mutex = new ReentrantLock(true);
    public SalvaUtente(String who)  {
        userData=new UserDAO();
        String [] log=userData.selectUser(who);
        userid=log[0];
        password=log[1];
        type=log[2];
        email=log[3];
    }
    public SalvaUtente(){
        userid=password=type=null;
        randomno = new Random();
    }
    public boolean  checkEmail(String input){
        UserDAO user=new UserDAO();
        return user.checkMail(input);
    }
    public boolean sendMail(String to) {
        try{
            UserDAO user=new UserDAO();
            String []data = user.recover(to);
            if(data!=null){
                JavaMailUtil email=new JavaMailUtil();
                String text="Your userid is .:     "+data[0]+"\nYour password is .:        "+data[1];
                email.setText(text);
               return sendMail(to);
            }
            return false  ;
        } catch (Exception e) {
            return false;
        }
    }
    private String getUid(){
        int random;
        int min=1000000;
        int max=9999999;
        String check=null;
        boolean different=true;
        UserDAO usr=new UserDAO();
        mutex.lock();
        ArrayList<String> uidList= usr.getUID();
        if(uidList==null)return "0000000";
        while(different){
            random= (randomno.nextInt()*(max-min)) + min;
            different=false;
            check=""+random;
            for(String uid : uidList){
                if(check.equals(uid)){
                    different=true;
                }
            }
        }
        mutex.unlock();
        return check;
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
    public boolean setEmail(String input){
        if(userData.setEmail(userid,input)){
            email=input;
            if(sendMail(email)){
                return true;
            }
        }
        return false;
    }
    public boolean registrationUSR(String password,String email,String type,int [] val,String description,String goal)  {
        boolean bool;
        String uid=getUid();
        bool= userData.registration(uid,password,type,val,description,email,goal);
        sendMail(email);
        return bool;
    }
    public boolean registrationPSY(String password, String email, String type) {
        boolean bool;
        String uid=getUid();
        bool= userData.registration(uid,password,type,email);
        if(bool)return sendMail(email);
        return false;
    }
    public boolean setFeed(String feed){
        return userData.feed(userid,feed);
    }
}