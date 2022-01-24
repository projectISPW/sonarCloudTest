//var on same line
package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.FormResultBean;


public class FormResultInterf1 {
    @FXML
    Text idForm;
    @FXML
    ImageView empathySlider;
    @FXML
    ImageView humorSlider;
    @FXML
    ImageView optimismSlider;
    ImageView [] param;
    @FXML
    ImageView ans1;
    @FXML
    ImageView ans2;
    @FXML
    ImageView ans3;
    @FXML
    ImageView ans4;
    @FXML
    ImageView ans5;
    @FXML
    ImageView ans6;
    ImageView [] images;
    @FXML
    Text by;
    FormResultBean bean ;
    PageMenu controller =new PageMenu();
    int [] values;
    public void initialize(){
        values=bean.exitValStatus();
        images= new ImageView[]{ans1,ans2,ans3,ans4,ans5,ans6};
        param=new ImageView[]{empathySlider,humorSlider, optimismSlider};
        int indice=0;
        for(ImageView image:images ){
            setSlider(image,values[indice++]);
        }
        values= bean.getParam();
        indice=0;
        for(ImageView image:param){
            setSlider(image,values[indice++]);
        }
        by.setText(bean.getData());
    }
    public void  setSlider(ImageView image,int val){
        //syntax check in bean
        String url="photo/val";
        url=url+val+".png";
        System.out.println(url);
        Image immagine=new Image(getClass().getResourceAsStream(url));
        image.setImage(immagine);
    }
    @FXML
    public void goBack(ActionEvent actionEvent) {
        controller.switchToPersonalForm(actionEvent);
    }
    @FXML
    public void goChat(ActionEvent actionEvent) {
        controller.switchToChat(actionEvent);
    }
    @FXML
    public void goHome(ActionEvent event){
        controller.switchToHome(event);
    }

}
