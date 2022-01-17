package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.SalvaUtente;

public class SignupController {
   private SalvaUtente user;
   public SignupController(){
       user=new SalvaUtente();
   }
   public boolean checkMail(String input){
       System.out.println("controllo mail nel controller"+user.checkEmail(input));
       return !user.checkEmail(input);
   }
   public boolean signup(String password,String type,String email,int [] val,String description,String goal){
       return user.registrationUSR(password,email,type,val,description,goal);
   }
   public boolean signup(String password,String type,String email){
       return user.registrationPSY(password,email,type);
   }
}
