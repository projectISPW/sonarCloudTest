package progettoispw.letmeknow;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import progettoispw.letmeknow.bean.SearchBean;

public class SearchControllerInterf1 {
   PageMenu controller= new PageMenu();
    @FXML
    protected Slider posSL;
    @FXML
    protected Slider empSL;
    @FXML
    protected Slider humSL;
    @FXML
    protected Slider carefulness;
    @FXML
    protected Label lb1;
    @FXML
    protected Label lb2;
    @FXML
    protected Label lb3;
    @FXML
    protected Label lb4;
    @FXML
    protected TextField inputTraits;
    @FXML
    protected TextField inputGoal;
    protected boolean [] clicked;
    @FXML
    protected ProgressBar progressBar;
    @FXML
    protected Button   buttonSearch;
    protected Slider [] sl ;
    protected Label[] labels;
    protected void incremProgress(int index){
        if(!clicked[index]){
            progress=progress+0.17;
            clicked[index]=true;
            progressBar.setProgress(progress);
            buttonSearch.setOpacity(progress);
        }
    }
    protected double progress;
    public SearchControllerInterf1(){
        progress=0;
        clicked= new boolean[]{false, false, false, false, false, false, false};
    }
    public void initialize(){
        labels= new Label[]{lb1, lb2, lb3,lb4};
        sl=new Slider[] {empSL,humSL,posSL, carefulness};
        for(int i=0;i<4;i++){
            int finalI = i;
            sl[i].valueProperty().addListener(
                    (ObservableValue<? extends Number> observableValue, Number number, Number t1) ->{
                    incremProgress(finalI);
                    progressBar.setProgress(progress);
                    if(finalI< 4)labels[finalI].setText(""+(int)sl[finalI].getValue());
                });
            }
        inputTraits.textProperty().addListener((observableValue, s, t1) ->incremProgress(4));
        inputGoal.textProperty().addListener((observableValue, s, t1) -> incremProgress(5));
    }
    SearchBean bean= new SearchBean();
    protected void researchByParameter(){
        Integer [] paramS=new Integer[labels.length-1];
        for(int i=0;i<4;i++){
                if (i==3){
                    if (clicked[3]) {
                        bean.enterAffinity(2-(int)sl[i].getValue());
                    }
                    else{
                        bean.enterAffinity(0);
                    }
                }
                else{
                    if(clicked[i])paramS[i]=((int)sl[i].getValue());
                    else paramS[i]=0;
                }
            }
        bean.enterParamSearch(paramS);
    }
    protected void researchByGoal(){
        if (clicked[5])bean.enterGoalSearch(inputGoal.getText());
    }
    protected void researchByDescripription(){
        if (clicked[4]) bean.enterDescrSearch(inputTraits.getText());
    }
    @FXML
    protected  void affinity(ActionEvent event ){
        bean.toMe();
        goResult(event);
    }
    @FXML
    public void search(ActionEvent actionEvent) {
        bean.reset();
        researchByParameter();
        researchByDescripription();
        researchByGoal();
        goResult(actionEvent);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event)  {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goResult(ActionEvent event) {
        controller.switchTo("resultSearch/interf1.fxml",event,"your research result");
    }
    @FXML
    protected void goBack()  {
        controller.backTo();
    }

}
