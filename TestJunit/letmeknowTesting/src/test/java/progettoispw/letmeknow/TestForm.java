package progettoispw.letmeknow;

import org.junit.Test;
import progettoispw.letmeknow.controller.Form;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;
//FRANCESCO D'AMATA
public class TestForm {
    Form form=new Form();
    Random rand=new Random();
    public void decrement(String userid){
        int []  older = form.getParam(userid);
        int [] newParam =form.setDecremForm(userid);
        for(int i=0;i<3;i++)assertTrue(older[i]>=newParam[i]);
    }
    public void increment(String userid){
        int []  older = form.getParam(userid);
        int [] newParam =form.setIncremForm(userid);
        for(int i=0;i<3;i++)assertTrue(newParam[i]>=older[i]);
    }
    public void takeForm(List<String>uids){
        int val;
        for(String uid:uids){
            val=rand.nextInt(100);

            if(val%2==0){
                decrement(uid);
            }else{
                increment(uid);
            }
        }
    }
    @Test
    public void testForm(){
        //it test the return of a signup and his log
        int [] counter=new int[3];
        for(int i=0;i<3;i++)counter[i]=form.getCounterFrom("5555555",i+1);//it can be used any userid
        TestLog log=new TestLog();
        List<String> uids=log.getUsrUids();
        for(int i=0;i<3;i++)takeForm(uids);
        int [] newCounter=new int[3];
        for(int i=0;i<3;i++)newCounter[i]=form.getCounterFrom("5555555",i+1);//it can be used any userid
        for(int i=0;i<3;i++){
            assertTrue("the counter of each form must be incrementated",newCounter[i]>= counter[i]+uids.size());
        }
    }
}
