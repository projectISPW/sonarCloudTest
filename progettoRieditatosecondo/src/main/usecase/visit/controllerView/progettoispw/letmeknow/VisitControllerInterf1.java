package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.*;

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
    @FXML
    private AnchorPane currentPage;
    public VisitControllerInterf1() {
        bean=new VisitBean();
        chatBean=new ISCBean();
        userid=bean.getUserId();
    }

    public void initialize(){
        HomepagecontrollerInterf1 homepage=new HomepagecontrollerInterf1();
        if(userid==null)currentPage.getChildren().removeAll(currentPage.getChildren());
        userName.setText("User : #"+userid);
        Integer [] listaValori=bean.exitValue();
        homepage.setSlider(empathySlider,listaValori[0]);
        homepage.setSlider(humorSlider,listaValori[1]);
        homepage.setSlider(positivitySlider,listaValori[2]);
        String text=bean.exitDes();
        //System.out.println(text);
        personalDescription.setText(text);
        goal.setText(bean.exitGoal());
        tag.setText(bean.exitTag());
        listaValori=bean.exitData();
        date.setText(" "+listaValori[0]+"-"+listaValori[1]+"-"+listaValori[2]);
    }
    @FXML
    protected void goBack(ActionEvent event) {
        controller.switchToISC(event);
    }
    @FXML
    protected void goToSearch(ActionEvent event){
        controller.backTo();
    }
    @FXML
    protected void touchChat(ActionEvent event){
        chatBean.touched(userid);
        controller.switchTo("chat/interf1.fxml",event,"Chat");
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        controller.switchToHome(event);
    }

}
