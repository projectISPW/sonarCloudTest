package progettoispw.letmeknow.controller.utentiusr;
import progettoispw.letmeknow.controller.ConnectionDB;
import progettoispw.letmeknow.controller.utentiusr.Query;
import progettoispw.letmeknow.controller.utenti.SalvaUtenteMeta;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class UtenteSQL extends Query implements SalvaUtenteMeta {
    private Statement stmt;
    private ResultSet rst;

    public boolean feed(String userid,String input){
        return feed(stmt,userid,input);
    }


}
