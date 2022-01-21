//same line variables
package progettoispw.letmeknow;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import progettoispw.letmeknow.bean.searchBean;

import java.util.Vector;

public class SearchControllerInterf1 {
    //private AnchorPane pane;
   PageMenu controller= new PageMenu();
    //private String userid=getUserID();
    @FXML
    Slider posSL;
    @FXML
    Slider empSL;
    @FXML
    Slider humSL;
    @FXML
    Slider accuracy;
    @FXML
    Label lb1;
    @FXML
    Label lb2;
    @FXML
    Label lb3;
    @FXML
    Label lb4;
    @FXML
    TextField inputTraits;
    @FXML
    TextField inputGoal;
    boolean [] clicked;
    @FXML
    ProgressBar progressBar;
    @FXML
    Button   buttonSearch;

    Vector<Slider> sl ;
    private void attach(Slider slider){
        this.sl.add(slider);
    }
    private void incremProgress(int index){
        //System.out.println(progress);
        if(clicked[index]==false){
            progress=progress+0.17;
            clicked[index]=true;
            progressBar.setProgress(progress);
            buttonSearch.setOpacity(progress);
        }
    }

    private int indice;
    private double progress;

    public SearchControllerInterf1(){
        indice=0;
        progress=0;
        clicked= new boolean[]{false, false, false, false, false, false, false};
    }
    Label[] labels;
    public void initialize(){
        labels= new Label[]{lb1, lb2, lb3,lb4};
        sl=new Vector<Slider>();
        attach(empSL);
        attach(humSL);
        attach(posSL);
        attach(accuracy);
        for(Slider slider :sl){
                slider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    indice=sl.indexOf(slider);
                    incremProgress(indice);
                    progressBar.setProgress(progress);
                    if(indice< 4)labels[indice].setText(""+(int)slider.getValue());
                    }
                });
            }
        inputTraits.textProperty().addListener((observableValue, s, t1) -> {
            incremProgress(4);
        });
        inputGoal.textProperty().addListener((observableValue, s, t1) -> {
            incremProgress(5);
        });
    }
    searchBean bean= new searchBean();
    private void researchByParameter(){
        Integer [] paramS=new Integer[labels.length-1];
        for(Slider slider :sl){
            indice=sl.indexOf(slider);
            switch(indice) {
                case 3: {
                    if (clicked[3]) {
                        bean.enterAffinity(2-(int)slider.getValue());
                    }
                    else{
                        bean.enterAffinity(0);
                    } break;
                }
                default:{
                    if(clicked[indice])paramS[indice]=((int)slider.getValue());
                    else paramS[indice]=0;
                }
            }
        }
        bean.enterParamSearch(paramS);
    }
    private void researchByGoal(){
        if (clicked[5]){
        String input=inputGoal.getText();
        bean.enterGoalSearch(input);
    }}
    private void researchByDescription(){
        if (clicked[4]){
        String input=inputTraits.getText();
        bean.enterDescrSearch(input);
    }}
    @FXML
    private void affinity(ActionEvent event ){
        bean.toMe();
        goResult(event);
    }
    @FXML
    private void search(ActionEvent event ){
        researchByParameter();
        researchByDescription();
        researchByGoal();
        goResult(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        controller.switchToHome(event);
    }
    @FXML
    protected void goBack(ActionEvent event) {
        controller.switchToChat(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event)  {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goResult(ActionEvent event) {
        controller.switchTo("resultSearch/interf1.fxml",event,"your research result");
    }
}
