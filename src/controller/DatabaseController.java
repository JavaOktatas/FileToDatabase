package controller;

import model.Connect;
import model.DatabaseManager;

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

    public boolean setCitesTable( ArrayList<String> cities ) {

        DatabaseManager dbManager = new DatabaseManager( "__SETCITIES__" );
        boolean success = dbManager.setCitesData( conn, cities );

        return success;
    }
}
