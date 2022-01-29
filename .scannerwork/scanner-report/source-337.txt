package progettoispw.letmeknow;

public class WordCheck {
    private  int goAhead;
    private int contAhead;
    private int delta;
    private String text;
    public WordCheck(int deltaInput, int goAheadInput){
        delta=deltaInput;
        goAhead=goAheadInput;
    }
    public WordCheck(){
        delta=goAhead=-1;
    }
    public  String check(String inputText) {
        if(inputText==null)return null;
        String add;
        String before;
        for (int k = goAhead-delta,count =goAhead-delta; k < inputText.length(); k = k+1) {
            if(inputText.toCharArray()[k]=='\n'){
                count=0;
            }
            if (count==goAhead){
                add = inputText.substring(k);
                before = inputText.substring(0, k);
                inputText = before + "\n" + add;
                count =0;
            } else if(((count%goAhead)>(goAhead-delta)) && inputText.toCharArray()[k]== 32){
                add = inputText.substring(k+1);
                before = inputText.substring(0, k);
                inputText = before + "\n" + add;
                count=0;
            }else{
                count++;
            }
        }
        text=inputText;
        return  inputText;
    }
    public String check1(String inputText,String immetti){
        if(inputText==null)return null;
        String add;
        String before;
        int count=-1;
        int start=inputText.indexOf('#');
        int k=0;
        for(char c : inputText.toCharArray()){
            if(c=='#' && k!=start)
            {
                    add = inputText.substring(k);
                    before = inputText.substring(0, k);
                    inputText = before + immetti + add;
                    ++k;

            }++k;
        }
        return inputText;
    }
    public Integer contaInvio(String inputText){
        contAhead=1;
        for(char c : inputText.toCharArray()){
            if(c=='\n'){
                contAhead++;
            }
        }
        return contAhead;
    }
    public int highText() {
        int linee= contaInvio(text);
        if(linee>4){
            return linee* 21;
        }
        return 60;
    }
    public  boolean checkString(String inputText){
        if(inputText.length()>goAhead*3){
            return false ;
        }return true;
    }
    public  String checkLen(String inputText,int lenMax){
        if(inputText==null)return " ";
        inputText=inputText.replaceAll("\\n","");
        inputText=inputText.replaceAll("\\r","");
        inputText=inputText.replaceAll("\n","");
        if(inputText.length()<lenMax)return inputText;
        else {
            return inputText.substring(0,lenMax)+"...";
        }
    }
    public  String checkAhead(String inputText){
        int k=0;
        if(inputText==null)return null;
        for(char c : inputText.toCharArray()){
            if(c=='\n')
            {
                inputText.toCharArray()[k]=' ';
            }++k;
        }
        return inputText;
    }
}
//abcdefghilmnopqrstuvz123456789