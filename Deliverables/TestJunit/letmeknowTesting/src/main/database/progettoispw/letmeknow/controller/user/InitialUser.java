package progettoispw.letmeknow.controller.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InitialUser {
    protected String userid;
    private String password;
    private String type;
    private String email;
    private UserDAO userData;
    private Random randomno ;
    private static final  Lock mutex = new ReentrantLock(true);
    public InitialUser(String who)  {
        if(who !=null && who.length()==7 ){
        userData=new UserDAO();
        String [] log=userData.selectUser(who);
        if(log[0]!=null && log[1]!=null){
            userid=log[0];
            password=log[1];
            type=log[2];
            email=log[3];
        }
        }

    }
    public InitialUser(){
        userid=password=type=null;
        randomno = new Random();
    }
    public boolean  checkEmail(String input){
        UserDAO userDataInner=new UserDAO();
        return userDataInner.checkMail(input);
    }
    public boolean composeMail(String to) {
        UserDAO userDataInner=new UserDAO();
        String []data = userDataInner.recover(to);
        if(data[0]!=null && data[1]!=null){
            JavaMailUtil host=new JavaMailUtil();
            String text="Your userid is .:     "+data[0]+"Your password is .:        "+data[1];
            host.setText(text);
            return host.sendMail(to);
        }
        return false;
    }
    public boolean composeMail(String uid, String password, String mail) {
        JavaMailUtil host=new JavaMailUtil();
        String text="Your userid is .:     "+uid+"Your password is .:        "+password;
        host.setText(text);
        return host.sendMail(mail);
    }
    private String getUid(){
        int random;
        int min=1000000;
        int max=9999999;
        String check=null;
        boolean equal=true;
        UserDAO userDataInner=new UserDAO();
        mutex.lock();
        List<String> uidList=(ArrayList<String> )userDataInner.getUID();
        if(uidList==null)return "0000000";
        while(equal){
            random= (randomno.nextInt(max));
            equal=false;
            if(random<min-1)equal=true;
            check=""+random;
            if(!equal)for(String uid : uidList){
                if(check.equals(uid)){
                    equal=true;
                }
            }
        }
        mutex.unlock();
        return check;
    }
    public boolean checkUtente (String pswdInput){
        if(password!=null){
            return password.equals(pswdInput);
        }
        return false;
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
                return null ;
            }
        }
        return null;
    }
    public String getType() {
        return type;
    }
    public String getUserid(){
        return userid;
    }
    public boolean setPassword(String input){
        if(userData.setPswd(userid,input)){
            return composeMail(email);
        }
        return false;
    }
    public boolean setEmail(String input){
        if(userData.setEmail(userid,input)){
            email=input;
            if(composeMail(email)){
                return true;
            }
        }
        return false;
    }
    public boolean registrationUSR(String password,String email,String type,int [] val,String description,String goal)  {
        UserDAO userDataInner=new UserDAO();
        boolean bool;
        String uid=getUid();
        bool= userDataInner.registration(uid,password,type,val,description,email,goal);
        if(bool)return composeMail(uid,password,email);
        return bool;
    }
    public boolean registrationPSY(String password, String email, String type) {
        UserDAO userDataInner=new UserDAO();
        boolean bool;
        String uid=getUid();
        bool= userDataInner.registration(uid,password,type,email);
        if(bool)return composeMail(uid,password,email);
        return false;
    }
    public boolean setFeed(String feed){
        return userData.feed(userid,feed);
    }
}