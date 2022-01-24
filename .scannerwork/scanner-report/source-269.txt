package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.EditProfileController;

import java.util.Calendar;

public class UpdatePersonalGoalBean {
    private String userid;
    private String newObb;
    private String newTag;
    private String newDueDate;
    private Integer [] data;
    private Calendar cal;
    private PersonalGoalBean padre;
    private EditProfileController controller;
    public String getUserid() {
        return userid;
    }

    public UpdatePersonalGoalBean() {
        controller=new EditProfileController();
        userid= controller.getUserID();
        data=new Integer[]{0,0,0};
        cal=Calendar.getInstance();
        padre=new PersonalGoalBean();
        controller=new EditProfileController();
    }
    public void check(String ValueObb,String ValueTag, String ValueData) {
        if(!ValueObb.equals(""))newObb=ValueObb;
        else {
            newObb =padre.exitGoal();
        }
        if(!ValueTag.equals("")){
            if(ValueTag.toCharArray()[0]!='#'){
                System.err.println("error occurred on the tag");
                newTag=padre.exitTag();
            }else{
                newTag=ValueTag;
            }
        }else{
            newTag=padre.exitTag();
        }
        if(!ValueData.equals("") && ValueData.contains("-")){
            newDueDate =ValueData;
            //data=dateParser.parse(ValueData);
            int end= newDueDate.indexOf("-");
            data[0]=(Integer.parseInt(newDueDate.substring(0,end)));
            int beg=end;
            end= newDueDate.indexOf("-",end+1);
            data[1]=(Integer.parseInt(newDueDate.substring(beg+1,end)));
            beg=end;
            end= newDueDate.length();
            data[2]=(Integer.parseInt(newDueDate.substring(beg+1,end)));
            //System.out.println("prima inizializzazione data "+giorno+"-"+mese+"-"+anno);
            data=checkData(data);

        }
        else{
            data=padre.exitData();
        }
    }

    public Integer[] checkData(Integer [] date){
        if(cal.get(Calendar.YEAR)== date[2]  || data[2]==(cal.get(Calendar.YEAR)+1)){
            if(data[1]>((cal.get(Calendar.MONTH)+6)%12)) {
                System.err.println("monthly error");
                return createData();
            }
            return date;
        }
        else{
            System.err.println("yearly error");
            return createData();
        }


    }
    public Integer[] createData(){
        if(cal.get(Calendar.MONTH)<6){
            return (new Integer[] {cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH)+6,cal.get(Calendar.YEAR)});
        }
        else{
            return (new Integer[] {cal.get(Calendar.DAY_OF_MONTH),(cal.get(Calendar.MONTH)+6)%12,cal.get(Calendar.YEAR)+1});
        }
    }
    public void entryValue(String ValueObb,String ValueTag, String ValueData) {
        check(ValueObb,ValueTag,ValueData);
        controller.setGoal(newObb,newTag,data);
    }

}
