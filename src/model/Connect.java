package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private String database;
    private String user;
    private String password;
    private Connection conn;
    
    public Connect( String database, String user, String password ) {

        this.database = database;
        this.user = user;
        this.password = password;
        conn = null;
    }

    public void connecting() {

        try {
            
            conn = DriverManager.getConnection( "jdbc:mariadb://localhost:3306/" + database + "?user=" + user + "&password=" + password );

        } catch ( SQLException ex ) {
            
            System.out.println( "Hiba a kapcsolódás során.");
        }
    }

    public void closeConnect() {

        try {
            
            conn.close();

        } catch ( SQLException ex ) {
            
            System.out.println( "Hiba a lezárás során." );
        }
    }

    public Connection getConnection() { return conn; }
}
