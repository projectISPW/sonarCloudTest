package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.HomepageController;

public class PersonalDescriptionBean {
    private HomepageController controller=new HomepageController();
    public String exitValue(){

        String output= controller.returnDescription();

        return output;
    }
}
