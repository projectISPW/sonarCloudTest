package progettoispw.letmeknow;

import progettoispw.letmeknow.bean.LoginBean;
import progettoispw.letmeknow.bean.SignupBean;
import progettoispw.letmeknow.controller.user.UserDAO;

import java.util.Random;

public class Log {
    Random rand=new Random();
    public  String testLogin(String userid,String password){
        LoginBean bean=new LoginBean(userid);
        return bean.getLog(password);
    }
    public Boolean testSignupUsr(String password,String email){
        SignupBean bean=new SignupBean();
        return bean.signupUSR(password,email,new int []{(rand.nextInt(4)+1),(rand.nextInt(4)+1),(rand.nextInt(4)+1)},"input by test","input by test");
    }
    public Boolean testSignupPsy(String password,String email){
        SignupBean bean=new SignupBean();
        return bean.signupPSY(password,email);
    }
    public String getUid(String email){
        UserDAO inner=new UserDAO();
        return inner.recover(email)[0];
    }
}
