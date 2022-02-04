package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.*;

import java.util.Optional;


public class HomepageEditControllerInterf1 {
    protected  PageMenu controller;
    @FXML
    protected ImageView empathySlider;
    @FXML
    private ImageView humorSlider;
    @FXML
    private TextField personalDes;
    @FXML
    private ImageView positivitySlider;
    @FXML
    private TextField tag;
    @FXML
    private TextField goal;
    @FXML
    private TextField date;
    @FXML
    private Text userName;
    private HomepagecontrollerInterf1 home;
    private HomepageEditBean bean;
    private HomepageBean homepageBean;
    public HomepageEditControllerInterf1(){
        bean=new HomepageEditBean();
        homepageBean=new HomepageBean(false);
        home =new HomepagecontrollerInterf1();
        controller=new PageMenu();
    }
    public void initialize() {

        userName.setText("User : "+bean.getUserid());
        Integer [] listaValori=homepageBean.getParam();
        home.setSlider(empathySlider,listaValori[0]);
        home.setSlider(humorSlider,listaValori[1]);
        home.setSlider(positivitySlider,listaValori[2]);
        personalDes.setPromptText(homepageBean.getDescription());
        goal.setPromptText(homepageBean.getGoal());
        tag.setPromptText(homepageBean.getTag());
        listaValori=homepageBean.getData();
        date.setPromptText(" "+listaValori[0]+"-"+listaValori[1]+"-"+listaValori[2]);
    }

    @FXML
    public void saveChanges(ActionEvent event)  {
        boolean bool;
        bool=bean.setGoal(goal.getText());
        if(bool)bool=bean.setDescription(personalDes.getText());
        if(bool)bool=bean.setTag(tag.getText());
        if(bool)bool=bean.setGoal(goal.getText());
        if(bool)bool=bean.setDate(date.getText());
        if(bool){
            goal.setText("");
            tag.setText("");
            date.setText("");
            personalDes.setText("");
            initialize();
        }
        else{
            Exceptions.exceptionEditProfileOccurred(event);
        }
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        controller.switchToISC(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event){
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void takeForm(ActionEvent event){
       FormCollectionResultsInterf1 formController=new FormCollectionResultsInterf1();
       formController.takeForm(event);
    }
}
