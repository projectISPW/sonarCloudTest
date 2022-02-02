package progettoispw.letmeknow.controller.usruser;

public class ParameterSliders {
    private Integer  emp;
    private Integer hum;
    private Integer opt;
    public ParameterSliders() {
        emp=hum=opt=1;
    }
    public Integer getOpt() {
        return opt;
    }
    public Integer getHum() {
        return hum;
    }
    public int getEmp() {
        return emp;
    }
    public void setEmp(String  emp) {
        if(emp!=null)this.emp=Integer.parseInt(emp);
    }
    public void setHum(String  hum) {
        if(hum!=null)this.emp=Integer.parseInt(hum);
    }
    public void setOpt(String opt) {
        if(opt!=null)this.opt=Integer.parseInt(opt);
    }
    public Integer[] getAll(){
        return new Integer[]{emp,hum,opt};
    }
}
