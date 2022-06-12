import employee.*;
import terrain.Land;
import terrain.Machine;
import terrain.Stock;
import vehicle.Forklift;
import vehicle.Truck;
import vehicle.Vehicle;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Stock landStock = new Stock();
        Stock machineInputStock = new Stock();


        //Add trunks to stocks
        List<Wood> startingWoodTestList = new ArrayList<Wood>();
        List<Wood> endingWoodTestList = new ArrayList<Wood>();

        for(int i = 0 ; i < 5 ; i++){
            startingWoodTestList.add(new Wood());
            endingWoodTestList.add(new Wood());
        }

        landStock.addWood(startingWoodTestList);
        machineInputStock.addWood(endingWoodTestList);




        //== Woodcutter part
        Woodcutter w = new Woodcutter("Fiher", 1, 2);
        Woodcutter w2 = new Woodcutter("Creut", 4, 2);
        Land l = new Land(landStock);

        w.setLand(l);
        w2.setLand(l);

        //Thread safe
        w.startWorking();

        //Since there are shared objects between these threads we need to be cautious
        //TODO CHANGE
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w2.startWorking();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(l.toString());




        //== Vehicle part from forest to machine
        Vehicle truck1 = new Truck();

        Employee truckDriver1 = new Driver(landStock, machineInputStock, truck1);
        EmployeeCategory truckDrivers = new DriverCategory();
        truckDrivers.addEmployee(truckDriver1);
        truckDrivers.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            // ...
        }




        //== Machine part
        Stock machineOutputStock = new Stock();
        Machine machine = new Machine("Cute machine", 15, machineInputStock, machineOutputStock);
        machine.startWorking();


        //== Forklift part
        Stock commandStock = new Stock();
        Vehicle forklift1 = new Forklift();

        Employee forkliftDriver1 = new Driver(machineOutputStock, commandStock, forklift1);
        EmployeeCategory forkliftDrivers = new DriverCategory();
        forkliftDrivers.addEmployee(forkliftDriver1);
        forkliftDrivers.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            // ...
        }

        // Display for test purposes
        while(true){
            System.out.println(">>>>>>");
            System.out.println("Stock terrain number of trunks : " + landStock.getCurrentCapacity());
            System.out.println("Stock machine Input number of trunks : " + machineInputStock.getCurrentCapacity());
            System.out.println("Stock machine Output number of planks : " + machineOutputStock.getCurrentCapacity());
            System.out.println("Stock command number of planks : " + commandStock.getCurrentCapacity());
            System.out.println("<<<<<<<");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }
}
