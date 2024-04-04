package controller;

import model.WorkerFileReader;
import model.Worker;

import java.util.ArrayList;

public class FileController {

    protected ArrayList<Worker> workers;
    private DatabaseController dbCtr;

    public FileController( DatabaseController dbCrt ) {

        this.dbCtr = dbCrt;
    }

    public ArrayList<Worker> getWorkers() {

        WorkerFileReader wfr = new WorkerFileReader();
        workers = new ArrayList<>();

        workers = wfr.readFile( "feherBt.txt" );

        return workers;
    }
}
