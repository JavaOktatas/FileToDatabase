package controller;

import java.util.ArrayList;
import model.Worker;

public class MainController {

    private FileController fileCtrl;
    private DatabaseController dbCtrl;
    private ArrayList<Worker> workers;

    public MainController() {

         fileCtrl = null;
         dbCtrl = null;
         start();
    }

    public void start() {

        dbCtrl = new DatabaseController();
        fileCtrl = new FileController( dbCtrl );
        getWorkersFromFile();
    }

    public void getWorkersFromFile() {

        workers = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();
        workers = fileCtrl.getWorkers();
        
        for (int i = 0; i < workers.size(); i++) {

            Worker worker = workers.get(i);
            if ( !cities.contains( worker.getCity() )) {

                cities.add( worker.getCity() );
            }
        }
        System.out.println( cities );
    }
}
