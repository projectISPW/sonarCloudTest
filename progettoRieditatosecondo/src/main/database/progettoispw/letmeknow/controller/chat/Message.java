package progettoispw.letmeknow.controller.chat;

public class Message {
    private String reciver;
    private String sender;
    private String text;
    public String getText() {
        return text;
    }
    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

}
