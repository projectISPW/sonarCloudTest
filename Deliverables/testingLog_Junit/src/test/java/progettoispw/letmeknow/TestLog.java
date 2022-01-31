package progettoispw.letmeknow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertTrue;

public class TestLog {
    Random rand=new Random();
    Log log =new Log();
    public void testloginUsr(String userid,String password){
        //it test the return of the log
        String result= log.testLogin(userid,password);
        assertTrue(result.equals("psy")||result.equals("usr"));
    }
    public boolean testSignup(String mail,String password){
       int val=rand.nextInt(100);
       Boolean bool;
       if(val%2 ==0){
           bool=log.testSignupPsy(password,mail);
           System.out.println("Mail input .:"+mail+"    signup as psychologist  status of signup    "+bool);
       }else{
           bool=log.testSignupUsr(password,mail);
           System.out.println("Mail input .:"+mail+"    signup as normal user   status of signup    "+bool);
       }
       return bool;
    }
    @Test
    public void testGlobalLog(){
        //it test the return of a signup and his log
        List<String>emails=new ArrayList<>();
        int val;
        boolean bool;
        for(int i=0;i<10;i++){
            val=rand.nextInt(10000);
            emails.add("trymail"+val+"@gmail.com");
        }
        List<String> listUids=new ArrayList<>();
        String password = "passwordTest";
        //test on the signup
        for(String email:emails){
            bool=testSignup(email,password);
            if(bool)listUids.add(log.getUid(email));
        }
        //test of the log
        for(String uids:listUids){
            testloginUsr(uids,password);
        }
        //test if every user has a different uid
        for(int i=0;i<listUids.size();i++){
            for(int j=i+1;j<listUids.size();j++){
                assertTrue(!listUids.get(i).equals(listUids.get(j)));
            }
        }
    }
}
