package controller;

import model.WorkerFileReader;
import model.Worker;

import java.util.ArrayList;

public class FileController {

    public FileController() {

    }

    public ArrayList<Worker> getWorkers() {

        WorkerFileReader wfr = new WorkerFileReader();
        ArrayList<Worker> workers = new ArrayList<>();

        workers = wfr.readFile( "feherBt.txt" );

        return workers;
    }
}
