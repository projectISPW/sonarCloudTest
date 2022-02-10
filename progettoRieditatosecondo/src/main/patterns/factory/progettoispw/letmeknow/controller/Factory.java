package progettoispw.letmeknow.controller;

public class Factory {
    public static boolean tryLog(String userid, String password){
        boolean bool=true;
        ConcreteUsrUser.reset();
        ConcretePsyUser.reset();
        if (ConcreteUsrUser.checkCredentials(userid,password)){
            ConcreteUsrUser.setAll(userid);
            ConcreteUsrUser.getUsrUser();
        }
        else if(ConcretePsyUser.checkCredentials(userid,password)){
            ConcretePsyUser.setAll(userid);
            ConcreteUsrUser.getUsrUser();
        }
        return bool;
    }

    public User getUser(){
        if(ConcreteUsrUser.getUsrUser()==null){
            return ConcretePsyUser.getPsyUser();
        }
        else{
            return ConcreteUsrUser.getUsrUser();
        }
    }
}
