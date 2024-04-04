package controller;

import model.Connect;
import java.sql.Connection;
import java.util.ArrayList;

public class DatabaseController {

    private Connection conn;

    public DatabaseController() {

        buildConnection();
    }

    public void buildConnection() {

        Connect connect = new Connect( "tanar_worker", "tanar", "123" );
        connect.connecting();
        conn = connect.getConnection();
    }

    public void setCitesTable( ArrayList<String> cities ) {

        
    }
}
