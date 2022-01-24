package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utenti.SalvaUtente;

public class RecoverPswdController {
        SalvaUtente user;
        public RecoverPswdController(){
            user=new SalvaUtente();
        }
        public boolean sendMail(String input){
            return user.composeMail(input);
        }
}
