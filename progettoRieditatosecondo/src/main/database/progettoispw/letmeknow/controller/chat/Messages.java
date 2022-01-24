package progettoispw.letmeknow.controller.chat;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Messages {
    private String userid;
    private MessageDAO messageData;
    private ArrayList<Message> sendRecived;
    private String touched;
    public Messages(String who)  {
            userid=who;
            messageData=new MessageDAO();
            getAllChat();
    }
    public String getUserid() {
        return userid;
    }
    public List<Message> getAllChat(){
        sendRecived= (ArrayList<Message>)
        messageData.getRecivedSentMessage(userid);
        return sendRecived;
    }
    public void attach(String usr,ArrayList<String>list){
        if (list.contains(usr)==false) {
            list.add(usr);
        }
    }
    public List<String> getUsers(){
        ArrayList<String> users=new ArrayList<String>();
        ArrayList<Message>inner= (ArrayList<Message>)getAllChat();
        for(Message msg:inner){
            attach(msg.getSender(),users);
            attach(msg.getReciver(),users);
        }
        users.remove(userid);
        return users;
    }
    public List<Message>orderByTime(List<Message>V){
        Message temp;
        int j;
        for(int i =0;i<V.size();i++){
            temp=V.get(i);
            j=i;
            while(j>0 &&   temp.getDate().isAfter(V.get(j-1).getDate()))
            {
                V.set(j,V.get(j-1));
                j=j-1;
            }
            V.set(j,temp);
        }
        return V;
    }
    public List<Message> getLast(){
        List<Message> lastmessages;
        ArrayList<String>users= (ArrayList<String>) getUsers();
        lastmessages =new ArrayList<>();
        for(String user:users){
            lastmessages.add(lstMsgWith(user));
       }
        lastmessages= orderByTime(lastmessages);
        return lastmessages;
    }
    public Message lstMsgWith(String user) {
        ArrayList<Message>inner= (ArrayList<Message>) chat(user,true);
        Message last = null;
        for(Message msg:inner){
            if(last==null)last=msg;
            if(msg.getDate().isAfter(last.getDate()))last=msg;
        }
        return last;
    }
    public List<Message> chat(String user2,boolean speed){
        ArrayList<Message>chat=new ArrayList<>();
        if(!speed){
            return messageData.getRecivedSentMessage(userid,user2);
        }
        if(sendRecived==null)getAllChat();
        for(Message msg:sendRecived){
            if(msg.getReciver().equals(user2)||msg.getSender().equals(user2)){
                chat.add(msg);
            }
        }
        return chat;
    }
    public void newMessage(String text,String to) {
        messageData.newMessage(userid,to,text);
        getAllChat();
    }
    public void setTouched(String touched) {
        this.touched = touched;
    }
    public String getTouched() {
        return touched;
    }
    public ArrayList<Message> getLocalSearch(String word) {
        ArrayList <Message> founded=new ArrayList<>();
        getAllChat();
        for(Message msg:sendRecived)if(msg.getText().contains(word))founded.add(msg);
        founded= (ArrayList<Message>) orderByTime(founded);
        return founded;
    }
}
