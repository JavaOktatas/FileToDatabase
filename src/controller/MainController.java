package controller;

public class MainController {

    private FileController fileCtrl;
    private DatabaseController dbCtrl;

    public MainController() {

         fileCtrl = null;
         dbCtrl = null;
         start();
         getWorkersFromFile();
    }

    public void start() {

        fileCtrl = new FileController();
        dbCtrl = new DatabaseController();
    }

    public void getWorkersFromFile() {

        fileCtrl.getWorkers();
    }
}
