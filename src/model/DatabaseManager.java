package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

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
}
