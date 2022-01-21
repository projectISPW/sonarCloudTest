package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.*;

import java.io.IOException;
public class VisitControllerInterf1{
    private String userid;
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
    private VisitBean bean;
    private ISCBean chatBean;
    public VisitControllerInterf1() throws InterruptedException {
        bean=new VisitBean();
        chatBean=new ISCBean();
        userid=bean.getUserId();
    }

    public void initialize(){
        userName.setText("User : #"+userid);
        SliderBean sliderVal=new SliderBean();
        Integer [] listaValori=bean.exitValue();
        setSlider(empathySlider,listaValori[0]);
        setSlider(humorSlider,listaValori[1]);
        setSlider(positivitySlider,listaValori[2]);
        String text=bean.exitDes();
        //System.out.println(text);
        personalDescription.setText(text);
        goal.setText(bean.exitGoal());
        tag.setText(bean.exitTag());
        listaValori=bean.exitData();
        date.setText(" "+listaValori[0]+"-"+listaValori[1]+"-"+listaValori[2]);
    }
    public void  setSlider(ImageView image,int val){
        //ho fatto il controllo sintattico nel bean
        String url="photo/val";
        url=url+val+".png";
        //System.out.println(url);
        Image immagine=new Image(getClass().getResourceAsStream(url));
        image.setImage(immagine);
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        controller.switchToChat(event);
    }
    @FXML
    protected void touchChat(ActionEvent event) throws IOException {
        chatBean.touched(userid);
        controller.switchTo("chat/interf1.fxml",event,"Chat");
    }

    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }

}
