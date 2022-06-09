import terrain.Stock;
import vehicle.Truck;
import vehicle.Vehicle;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Woodcutter w = new Woodcutter("Fiher", 1, 2);
        Woodcutter w2 = new Woodcutter("Creut", 4, 2);
        Land l = new Land();

        Stock startingTestStock = new Stock();
        Stock endingTestStock = new Stock();
        Vehicle truck1 = new Truck();

        List<Wood> startingWoodTestList = new ArrayList<Wood>();
        List<Wood> endingWoodTestList = new ArrayList<Wood>();

        for(int i = 0 ; i < 5 ; i++){
            startingWoodTestList.add(new Wood());
            endingWoodTestList.add(new Wood());
        }

        startingTestStock.addWood(startingWoodTestList);
        endingTestStock.addWood(endingWoodTestList);

        System.out.println("terrain.Stock de départ nombre de troncs : " + startingTestStock.getCurrentCapacity());
        System.out.println("terrain.Stock d'arrivée nombre de troncs : " + endingTestStock.getCurrentCapacity());
        System.out.println("=====");

        Employee driver1 = new Driver(startingTestStock, endingTestStock, truck1);
        EmployeeCategory drivers = new DriverCategory();
        drivers.addEmployee(driver1);
        drivers.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            // ...
        }
        System.out.println("terrain.Stock de départ nombre de troncs : " + startingTestStock.getCurrentCapacity());
        System.out.println("terrain.Stock d'arrivée nombre de troncs : " + endingTestStock.getCurrentCapacity());

        w.setLand(l);
        w2.setLand(l);
        
        //Thread safe
        w.startWorking();

        //Since there are shared objects between these threads we need to be cautious 
        //TO_CHANGE
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

    }
}
