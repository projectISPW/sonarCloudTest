package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.*;

public class SliderBean {
    private HomepageController controller;
    public Integer [] exitValue(){
        Integer values []={0,0,0};
        controller=new HomepageController();
        //values[0]=1;  values[1]=1; values[2]=1;

        values[0]=controller.returnEmpathyValues();
        values[1]=controller.returnHumorValues();
        values[2]=controller.returnOptimismValues();
        for(int i =0;i<2;i++){
            if(values[i]>5 || values[i]<1){
                System.err.println("error occurred");
            }
        }
        return values;
    }
}
