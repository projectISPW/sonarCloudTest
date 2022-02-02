package progettoispw.letmeknow;

import org.junit.Test;
import progettoispw.letmeknow.controller.Message;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;
//OLENIC EDUARD
public class TestMessage {
    Random rand=new Random();
    private Message chat=new Message();
    public void sendMsg(String userid1,List<String>uids){
            int val;
            String textMsg="Hello";
            String compare;
            System.err.println(" i am testing the "+userid1);
            for(String uid:uids){
                if(userid1!=uid){
                    val=rand.nextInt(100);
                    if(val%2==0){
                        chat.newMsg(userid1,uid,textMsg+val+"times");
                    }
                    else {
                        chat.newMsg(uid,userid1,textMsg+val+"times");
                    }
                    compare=chat.getRecived(userid1,uid);
                    assertEquals("compairing the users",uid,compare);
                }
            }
        }
    @Test
    public void testSendReciveMessage(){
        //it test the return of a signup and his log
        TestLog log=new TestLog();
        List<String> uids=log.getUsrUids();
        for(String uid:uids){
            sendMsg(uid,uids);
        }
    }
}
