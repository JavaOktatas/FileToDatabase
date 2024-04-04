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

        } catch ( Exception ex ) {
            
            System.out.println( "Fájl olvasási hiba" );
        }
        return sql;
    }
}
