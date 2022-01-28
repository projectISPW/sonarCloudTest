package progettoispw.letmeknow.controller.utentiusr;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Goal {
    private  String obiettivo;
    private   String tag;
    private  Integer[] dataEuropean =new Integer[3];//EUROPEAN FORMAT DD-MM-YYYY

    public void setObiettivo(String string){
        obiettivo=string;
    }
    public void setStrDataAmericanEurope(String input){
        //CONVERTED FROM American to  INPUT DD-MM-YYYY
        int end=input.indexOf("-");
        dataEuropean[2]=(Integer.parseInt(input.substring(0,end)));
        int beg=end;
        end=input.indexOf("-",end+1);
        dataEuropean[1]=(Integer.parseInt(input.substring(beg+1,end)));
        beg=end;
        end=input.length();
        dataEuropean[0]=(Integer.parseInt(input.substring(beg+1,end)));
    }
    public void setStrDataEurope(String input){
        //CONVERTED FROM  DD-MM-YYYY to American
        int end=input.indexOf("-");
        dataEuropean[0]=(Integer.parseInt(input.substring(0,end)));
        int beg=end;
        end=input.indexOf("-",end+1);
        dataEuropean[1]=(Integer.parseInt(input.substring(beg+1,end)));
        beg=end;
        end=input.length();
        dataEuropean[2]=(Integer.parseInt(input.substring(beg+1,end)));
        checkData();
    }
    private void checkData(){
        LocalDate inner=LocalDate.of(dataEuropean[2],dataEuropean[1],dataEuropean[0]);
        LocalDate compare=LocalDate.now().plusMonths(6);
        if(inner.isAfter(compare)){
            dataEuropean[0]=compare.getDayOfMonth();
            dataEuropean[1]= compare.getMonthValue();
            dataEuropean[2]= compare.getYear();
        }
    }
    public String getAmericanDataStr(){
        String convert=String.format("%d-%d-%d", dataEuropean[2], dataEuropean[1], dataEuropean[0]);
        return convert;
    }
    public void setTag(String string){
        tag=string;
    }
    public String getObiettivo(){
        return obiettivo;
    }
    public Integer[] getDataEuropean(){return dataEuropean;}
    public String getTag(){
        return tag;
    }
    public boolean getExpired(){
        LocalDate inner=LocalDate.of(dataEuropean[2],dataEuropean[1],dataEuropean[0]);
        LocalDate compare =LocalDate.now();
        return compare.isAfter(inner);
    }
    public void getStatus(){
        System.out.println("il tuo obiettivo personale:"+obiettivo+"i tuoi tag:"+tag+"la tua scadenza:"+ dataEuropean[0]+"/"+ dataEuropean[1]+"/"+ dataEuropean[2]);
    }
}
