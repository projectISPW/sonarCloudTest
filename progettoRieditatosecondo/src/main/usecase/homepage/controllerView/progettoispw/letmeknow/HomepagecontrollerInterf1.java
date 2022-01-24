package progettoispw.letmeknow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.SliderBean;
import progettoispw.letmeknow.bean.*;

import java.io.IOException;
/*
-cambiare foto clessidra se obiettivo scaduto
-possibilita di mettere slider che bloccano il proprio valore invece che lasciare l'image view
 */

public class HomepagecontrollerInterf1 implements Interf1ButtonBar{
    protected String userid;
    protected PageMenu controller= new PageMenu();
    @FXML
    protected ImageView empathySlider;
    @FXML
    protected ImageView humorSlider;
    @FXML
    protected ImageView positivitySlider;
    @FXML
    protected Label personalDescription;
    @FXML
    protected Label tag;
    @FXML
    protected Label goal;
    @FXML
    protected Label date;
    @FXML
    protected Text userName;
    protected UseridBean id;
    public HomepagecontrollerInterf1(){
        id=new UseridBean();
        userid= id.getUserId();
    }
    public void initialize(){
        userName.setText("User : "+userid);
        SliderBean sliderVal=new SliderBean();
        Integer [] listaValori=sliderVal.exitValue();

        setSlider(empathySlider,listaValori[0]);
        setSlider(humorSlider,listaValori[1]);
        setSlider(positivitySlider,listaValori[2]);

        PersonalDescriptionBean descrizione=new PersonalDescriptionBean();
        String text=descrizione.exitValue();
        personalDescription.setText(text);
        PersonalGoalBean obb=new PersonalGoalBean();
        goal.setText(obb.exitGoal());
        tag.setText(obb.exitTag());
        listaValori=obb.exitData();
        //date.setText(data.toString());
        date.setText(" "+listaValori[0]+"-"+listaValori[1]+"-"+listaValori[2]);
    }

    public void  setSlider(ImageView image,int val){
        //ho fatto il controllo sintattico nel bean
        String url="photo/val";
        url=url+val+".png";
        System.out.println(url);
        Image immagine=new Image(getClass().getResourceAsStream(url));
        image.setImage(immagine);
    }


    @FXML
    protected void editProfile(ActionEvent event) throws IOException {
        controller.switchTo("homepageEdit/interf1.fxml",event,"Edit Profile");
    }
    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        controller.switchToSettings(event);
    }
    @FXML
    protected void goBack() {
        controller.backTo();
    }
    @FXML
    protected  void goToISC(ActionEvent event){
        controller.switchToISC(event);
    }
    @FXML
    protected  void goToHome(ActionEvent event){controller.switchToHome(event);}
    @FXML
    protected void goToPersonalForm (ActionEvent event ){controller.switchToPersonalForm(event);}
}
