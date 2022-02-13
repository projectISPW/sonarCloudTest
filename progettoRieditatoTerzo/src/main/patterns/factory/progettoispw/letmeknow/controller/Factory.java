package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.user.InitialUser;

public class Factory {
    public void concreteInitialUser(String userid){
        ConcreteInitialUser.reset();
        ConcreteInitialUser.setAll(userid);
    }
    public void tryLog(String userid, String password){
        ConcreteUsrUser.reset();
        ConcretePsyUser.reset();
        if (ConcreteUsrUser.checkCredentials(userid,password)){
            ConcreteUsrUser.setAll(userid);
            concreteInitialUser(userid);
        }
        else if(ConcretePsyUser.checkCredentials(userid,password)){
            ConcretePsyUser.setAll(userid);
            concreteInitialUser(userid);
        }
    }
    public User getUser(){
        if(ConcreteUsrUser.getUsrUser()==null){
            return ConcretePsyUser.getPsyUser();
        }
        else{
            return ConcreteUsrUser.getUsrUser();
        }
    }
    public InitialUser getInitialUser(){
        return ConcreteInitialUser.getUser();
    }
}
