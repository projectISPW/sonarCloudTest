package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.user.InitialUser;

public class RecoverPswdController {
        InitialUser user;
        public RecoverPswdController(){
            user=new InitialUser();
        }
        public boolean sendMail(String input){
            return user.composeMail(input);
        }
}
