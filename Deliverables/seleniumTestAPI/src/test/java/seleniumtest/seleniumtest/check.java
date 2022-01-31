package seleniumtest.seleniumtest;

public class check {
    public static boolean extract(String s,Integer min){
        int start=10;
        String convert=s.substring(start);
        int converted=Integer.parseInt(convert);
        //System.out.println(converted);
        if(converted>min){
            System.out.printf("Numero citazioni maggiore di %d , valore pari a %d",min,converted);
            return true;
        }else{
            System.out.printf("Numero citazioni minore di %d , valore pari a %d",min,converted);
            return false;
        }
    }
}
