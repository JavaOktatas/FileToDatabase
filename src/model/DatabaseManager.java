package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;

public class DatabaseManager {

    private String fileName;

    public DatabaseManager( String fileName ) {

        this.fileName = "sql/" + fileName + ".sql";
    }

    private String[] getSql() {

        String[] sql = null;
        Path filePath = Path.of( fileName );
        
        try {
            
            String content = Files.readString( filePath );
            sql = content.split( ";" );
            
        } catch ( IOException ex ) {
            
            System.out.println( "Fájl olvasási hiba" );
            //System.out.println( ex.getMessage() );
        }
        return sql;
    }

    public boolean setCitesData( Connection conn, ArrayList<String> cities ) {

        PreparedStatement pstmt = null;
        String[] sql = getSql();
        try {
            
            for( String city : cities ) {

                pstmt = conn.prepareStatement( sql[ 0 ]);
                pstmt.setString( 1, city );
                pstmt.execute();
            }

            return true;

        } catch ( SQLException ex ) {
            
            System.out.println( "Hiba a kiírás során" );

            return false;
        }
    }

    public boolean setWorkersData( Connection conn, ArrayList<Worker> workers ) {

        PreparedStatement pstmt = null;
        String[] sql = getSql();
        try {
            
            for( Worker worker : workers ) {

                pstmt = conn.prepareStatement( sql[ 0 ] );
                pstmt.setString( 1, worker.getName() );
                pstmt.setString( 2, worker.getCity() );
                pstmt.setString( 3, worker.getAddress() );
                pstmt.setInt( 4, Integer.parseInt( worker.getSalary() ));
                pstmt.setInt( 5, Integer.parseInt( worker.getBonus() ));
                pstmt.setDate(6, Date.valueOf( worker.getBornDate() ));
                pstmt.setDate( 7, Date.valueOf( worker.getHireDate() ));
                pstmt.execute();

            }
        } catch ( SQLException ex ) {
            
            System.out.println( "Hiba a dolgozók kiírása során");
            System.out.println( ex.getMessage() );

            return false;
        }

        return true;
    }

    public boolean setDataToDatabase( Connection conn, ArrayList<Worker> workers, ArrayList<String> cities ) {

        PreparedStatement pstmt = null;
        String[] sql = getSql();
        try {
            
            for( String city : cities ) {

                pstmt = conn.prepareStatement( sql[ 0 ] );
                pstmt.setString( 1, city );
                pstmt.execute();
            }

            pstmt = null;
            
            for( Worker worker : workers ) {

                pstmt = conn.prepareStatement( sql[ 1 ] );
                pstmt.setString( 1, worker.getName() );
                pstmt.setString( 2, worker.getCity() );
                pstmt.setString( 3, worker.getAddress() );
                pstmt.setInt( 4, Integer.parseInt( worker.getSalary() ));
                pstmt.setInt( 5, Integer.parseInt( worker.getBonus() ));
                pstmt.setDate(6, Date.valueOf( worker.getBornDate() ));
                pstmt.setDate( 7, Date.valueOf( worker.getHireDate() ));
                pstmt.execute();
            }
            
            return true;

        } catch ( SQLException ex ) {
            
            System.out.println( "Hiba a kiírás során" );

            return false;
        }
    }
}
