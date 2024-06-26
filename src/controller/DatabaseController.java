package controller;

import model.Connect;
import model.DatabaseManager;
import model.Worker;

import java.sql.Connection;
import java.util.ArrayList;

public class DatabaseController {

    private Connection conn;

    public DatabaseController() {

        buildConnection();
    }

    public void buildConnection() {

        Connect connect = new Connect( "resahh_worker", "resahh", "hajakend" );
        connect.connecting();
        conn = connect.getConnection();
    }

    public boolean setCitesTable( ArrayList<String> cities ) {

        DatabaseManager dbManager = new DatabaseManager( "__SETCITIES__" );
        boolean success = dbManager.setCitesData( conn, cities );

        return success;
    }

    public boolean setWorkersTable( ArrayList<Worker> workers ) {

        DatabaseManager databaseManager = new DatabaseManager( "__SETWORKERS__" );
        boolean success = databaseManager.setWorkersData( conn, workers );

        return success;
    }

    public boolean setAllDataToWorkers( ArrayList<String> cities, ArrayList<Worker> workers ) {

        DatabaseManager dbManager = new DatabaseManager( "__SETFULLDATA__" );
        boolean success = dbManager.setDataToDatabase( conn, workers, cities );

        return success;
    }
}
