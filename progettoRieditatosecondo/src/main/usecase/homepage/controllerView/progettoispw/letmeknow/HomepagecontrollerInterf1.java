package progettoispw.letmeknow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.*;

public class HomepagecontrollerInterf1 {
    protected String userid;
    protected PageMenu controller;
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
    @FXML
    protected ImageView expired;
    protected HomepageBean bean;
    public HomepagecontrollerInterf1(){
        controller=new PageMenu();
        bean=new HomepageBean(false);
        userid= bean.getUserId();
    }
    public void initialize(){
        userName.setText("User : #"+userid);

        Integer[] arrayOut= bean.getParam();
        setSlider(empathySlider,arrayOut[0]);
        setSlider(humorSlider,arrayOut[1]);
        setSlider(positivitySlider,arrayOut[2]);

        personalDescription.setText(bean.getDescription());
        goal.setText(bean.getGoal());
        tag.setText(bean.getTag());
        arrayOut=bean.getData();
        date.setText(" "+arrayOut[0]+"-"+arrayOut[1]+"-"+arrayOut[2]);
        if(bean.getExpired() && expired!=null){
            Image image= new Image(getClass().getResourceAsStream("photo/expired.png"));
            expired.setImage(image);
        }
    }
    public void  setSlider(ImageView image,int val){
        //ho fatto il controllo sintattico nel bean
        String url="photo/val";
        url=url+val+".png";
        Image immagine=new Image(getClass().getResourceAsStream(url));
        image.setImage(immagine);
    }
    @FXML
    protected void editProfile(ActionEvent event) {
        controller.switchTo("homepageEdit/interf1.fxml",event,"Edit Profile");
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        controller.switchToSettings(event);
    }
    @FXML
    protected  void goToISC(ActionEvent event){
        controller.switchToISC(event);
    }
    @FXML
    protected  void goToHome(ActionEvent event){controller.switchToHome(event);}
    @FXML
    protected void goToPersonalForm (ActionEvent event ){controller.switchToPersonalForm(event);}
    @FXML
    protected void setSize(ActionEvent event ){
        controller.setSize("homepage/interf1.fxml",event);
    }
}
