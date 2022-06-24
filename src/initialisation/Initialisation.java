package initialisation;

import company.Company;
import demand.Customer;
import demand.MobileApp;
import demand.Website;
import employee.*;
import interfaceGraphique.GraphicalInterface;
import terrain.*;
import vehicle.Forklift;
import vehicle.Truck;
import vehicle.Vehicle;
import vehicle.VehicleCategory;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public class Initialisation {

    // Initialize forest
    Land firstLand = new Land();
    public Forest forest = new Forest(firstLand);


    // Terminals
    Website website = Website.getInstance();
    MobileApp mobileApp = MobileApp.getInstance();

    // Stock categories
    public StockCategory landStocks = new StockCategory(firstLand.getStock());
    public StockCategory inputMachineStocks;
    public StockCategory outputMachineStocks;
    public StockCategory commandStocks;

    // Employee categories
    public EmployeeCategory wcc = new WoodcutterCategory(forest);
    public EmployeeCategory planters = new PlanterCategory();
    public DriverCategory truckDrivers = new DriverCategory(landStocks, inputMachineStocks);
    public DriverCategory forkliftDrivers = new DriverCategory(outputMachineStocks, commandStocks);
    public MarketingManager marketingManager = new MarketingManager(100,100, website, mobileApp);





    // Vehicle categories
    public VehicleCategory trucks = new VehicleCategory(landStocks, inputMachineStocks, truckDrivers);
    public VehicleCategory forklifts = new VehicleCategory(outputMachineStocks, commandStocks, forkliftDrivers);


    public MachineCategory machines = new MachineCategory();






    // Start threads
    // TODO Initialise all categories
    public Initialisation(){
        //== Example of company creation (everything is static)
        //FIXME: these information are placeholders for now.

        Stock initialFinalStock = new Stock();
        this.machines = machines ;
        Company.init(
                "Test company",
                "Théo bien entendu le boss",
                "Bengladesh",

                // Here we create the customer list
                new Customer[]{
                        new Customer("Customer1"),
                        new Customer("Customer2"),
                        new Customer("Customer3"),
                        new Customer("Customer4"),
                        new Customer("Customer5"),
                        new Customer("Customer6")
                },
                150000,
                initialFinalStock
        );

        //== Terminals creation
        //== These objects are SINGLETONS (they cannot be instantiated more than once)
        // Call this once
        website.init(
                1500,
                150,
                5,
                10000
        );
        // Generate new demands
        // We can get the number of new demand by storing the return value of refresh
        int newDemands = website.refresh();
        // Get the list of demands
        website.getDemandList();

        // Call this once
        mobileApp.init(
                5000,
                200,
                10,
                10000
        );
        // Generate new demands
        mobileApp.refresh();

        // Get the list of demands
        mobileApp.getDemandList();

        System.out.println(website);
        System.out.println(mobileApp);




        //We add two wc to the land
        wcc.buy();
        wcc.buy();
        wcc.startWorking();


        Stock machineInputStock = new Stock();
        inputMachineStocks = new StockCategory(machineInputStock);

        //Add trunks to stocks
        List<Wood> startingWoodTestList = new ArrayList<Wood>();
        List<Wood> endingWoodTestList = new ArrayList<Wood>();

        for (int i = 0; i < 5; i++) {
            startingWoodTestList.add(new Wood());
            endingWoodTestList.add(new Wood());
        }

        forest.getStock(0).addWood(startingWoodTestList);
        machineInputStock.addWood(endingWoodTestList);


        //== Add one truck to truckCategory
        Vehicle truck1 = new Truck();


        Driver truckDriver1 = new Driver(forest.getStockCategory(), inputMachineStocks, truck1,1);
        truckDrivers.addDriver(truck1);
        truckDrivers.start();

        truck1.setDriver(truckDriver1);

        truckDriver1.startWorking();


        //== Machine part
        Stock machineOutputStock = new Stock();
        outputMachineStocks = new StockCategory(machineOutputStock);
        Machine machine = new Machine("Cute machine", 15, machineInputStock, machineOutputStock);
        machine.startWorking();


        //== Add one forklift to forkliftCategory
        Stock commandStock = new Stock();
        commandStocks = new StockCategory(commandStock);
        Vehicle forklift1 = new Forklift();

        Driver forkliftDriver1 = new Driver(outputMachineStocks, commandStocks, forklift1,1);
        forkliftDrivers.addDriver(forklift1);
        forkliftDrivers.start();

        forklift1.setDriver(forkliftDriver1);

        forkliftDriver1.startWorking();


        //== Generate graphical interface
        GraphicalInterface Interface = new GraphicalInterface(this);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            // ...
        }

        // Display for test purposes
        while (true) {
            System.out.println(">>>>>>");
            System.out.println("Stock terrain number of trunks : " + forest.getStock(0).getCurrentCapacity());
            System.out.println("Stock machine Input number of trunks : " + machineInputStock.getCurrentCapacity());
            System.out.println("Stock machine Output number of planks : " + machineOutputStock.getCurrentCapacity());
            System.out.println("Stock command number of planks : " + commandStock.getCurrentCapacity());
            System.out.println("<<<<<<<");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
