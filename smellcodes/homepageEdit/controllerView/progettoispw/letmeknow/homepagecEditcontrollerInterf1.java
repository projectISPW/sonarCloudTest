package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.*;


import java.io.IOException;



public class homepagecEditcontrollerInterf1 {
    private PageMenu controller=new PageMenu();
    @FXML
    private ImageView empathySlider;
    @FXML
    private ImageView humorSlider;
    @FXML
    private ImageView positivitySlider;
    @FXML
    private TextField personalDescription;
    @FXML
    private TextField tag;
    @FXML
    private TextField goal;
    @FXML
    private TextField date;
    @FXML
    private Text userName;
    private String userid;
    private HomepagecontrollerInterf1 home;
    private UpdatePersonalGoalBean obiettivo;
    private UpdatePersonalDescriptionBean descrizione;
    public homepagecEditcontrollerInterf1(){
        obiettivo=new UpdatePersonalGoalBean();
        descrizione = new UpdatePersonalDescriptionBean();
        home =new HomepagecontrollerInterf1();
    }
    public void initialize() {
        userid= obiettivo.getUserid();
        userName.setText("User : "+userid);
        SliderBean sliderVal=new SliderBean();
        Integer [] listaValori=sliderVal.exitValue();
        home.setSlider(empathySlider,listaValori[0]);
        home.setSlider(humorSlider,listaValori[1]);
        home.setSlider(positivitySlider,listaValori[2]);
        PersonalDescriptionBean descrizione=new PersonalDescriptionBean();//della Homepage
        String text=descrizione.exitValue();
        personalDescription.setPromptText(text);
        PersonalGoalBean obb=new PersonalGoalBean();//della homepage
        goal.setPromptText(obb.exitGoal());
        tag.setPromptText(obb.exitTag());
        listaValori=obb.exitData();
        date.setPromptText(" "+listaValori[0]+"-"+listaValori[1]+"-"+listaValori[2]);
    }

    @FXML
    public void saveChanges()  {
        obiettivo.entryValue(goal.getText(), tag.getText(),date.getText());
        descrizione.entryValue(personalDescription.getText());
        personalDescription.setText("");
        goal.setText("");
        tag.setText("");
        date.setText("");
        initialize();
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchToChat(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void takeForm(ActionEvent event){
        GoToFormBean takeFormBean=new GoToFormBean();
        int val=takeFormBean.getFormid();
        String name="formToTake/form"+val+"interf1.fxml";
        controller.switchTo(name,event,"fill the form");
    }
}