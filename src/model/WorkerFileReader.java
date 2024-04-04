package model;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WorkerFileReader {

    public WorkerFileReader() {}

    public ArrayList<Worker> readFile( String fileName ) {

        FileReader fr = null;
        ArrayList<Worker> workers = new ArrayList<>();

        try {
            
            fr = new FileReader( fileName );

        } catch ( FileNotFoundException ex ) {
            
            System.out.println( "Nincs meg a fájl" );
        }

        Scanner scan = new Scanner( fr );
        scan.nextLine();
        while( scan.hasNext() ) {

            String row = scan.nextLine();
            String[] rowSp = row.split( ":" );
            Worker worker = new Worker();

            worker.setName( rowSp[ 0 ]);
            worker.setCity( rowSp[ 1 ]);
            worker.setAddress( rowSp[ 2 ]);
            worker.setSalary( rowSp[ 3 ]);
            worker.setBonus( rowSp[ 4 ]);
            worker.setBornDate( rowSp[ 5 ]); 
            worker.setHireDate( rowSp[ 6 ]);

            workers.add( worker );
        }

        return workers;
    }
}
