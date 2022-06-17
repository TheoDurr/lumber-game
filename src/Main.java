import company.Company;
import demand.Customer;
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
        // Example of company creation (everything is static)
        Company.init(
                "Test company",
                "Théo bien entendu le boss",
                "Bengladesh",

                // Here we create the customer list
                new Customer[] {
                        new Customer("Customer1"),
                        new Customer("Customer2"),
                        new Customer("Customer3"),
                        new Customer("Customer4"),
                        new Customer("Customer5"),
                        new Customer("Customer6")
                }
        );


        //We create a new land with 2 woodcutters on it
        Land land = new Land();
        WoodcutterCategory wcc = new WoodcutterCategory();
        wcc.buy();
        wcc.buy();
        wcc.setLand(land);
        wcc.startWorking();


        Stock machineInputStock = new Stock();


        //Add trunks to stocks
        List<Wood> startingWoodTestList = new ArrayList<Wood>();
        List<Wood> endingWoodTestList = new ArrayList<Wood>();

        for(int i = 0 ; i < 5 ; i++){
            startingWoodTestList.add(new Wood());
            endingWoodTestList.add(new Wood());
        }

        land.getStock().addWood(startingWoodTestList);
        machineInputStock.addWood(endingWoodTestList);




        //== Vehicle part from forest to machine
        Vehicle truck1 = new Truck();

        Employee truckDriver1 = new Driver(land.getStock(), machineInputStock, truck1);
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
            System.out.println("Stock terrain number of trunks : " + land.getStock().getCurrentCapacity());
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
