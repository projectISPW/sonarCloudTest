package progettoispw.letmeknow;

import org.junit.Test;
import progettoispw.letmeknow.controller.Message;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//OLENIC EDUARD
public class TestMessage {
    Random rand=new Random();
    private Message chat=new Message();
    public void sendMsg(String userid1,List<String>uids){
        //it check the correct sendining of the message and the upgrade of the list
            int val;
            String textMsg="Hello";
            String [] compare;
            boolean bool=false;
            int index=0;
            for(String uid:uids){
                if(!userid1.equals(uid)){
                    val=rand.nextInt(100);
                    //it checks if the last message is recived or sended
                    if(val%2==0){
                        chat.newMsg(userid1,uid,textMsg+val+"times");
                        assertEquals("i am the sender",chat.getLmsg(userid1,uid));
                    }
                    else {
                        chat.newMsg(uid,userid1,textMsg+val+"times");
                        assertEquals("i am the receiver",chat.getLmsg(userid1,uid));
                    }
                    compare=chat.getListLmsgs(userid1);
                    //it check if the last chatted users is in the list of the recently chatted
                    while(!bool && index< compare.length){
                        if(compare[index]!=null){
                            bool=uid.equals(compare[index]);
                        }
                        index++;
                    }
                    assertTrue("compairing the users",bool);
                }
            }
        }
    @Test
    public void testSendReciveMessage(){
        //it test the return of a signup and his log
        TestLog log=new TestLog();
        List<String> uids=log.getUsrUids();
        chat.setSize(Message.ScreenSize.LAPTOP);
        for(String uid:uids){
            sendMsg(uid,uids);
        }
    }
}
