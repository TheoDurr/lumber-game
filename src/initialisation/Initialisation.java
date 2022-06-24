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


<<<<<<< HEAD
    // Employee categories
    public WoodcutterCategory wcc = new WoodcutterCategory();
=======
    // List of all categories in the game
    public Forest forest = new Forest();
    public EmployeeCategory wcc = new WoodcutterCategory(forest);
>>>>>>> f8acaf648caabe522eadfb4e261207f446413c2c
    public EmployeeCategory planters = new PlanterCategory();
    public DriverCategory truckDrivers = new DriverCategory();
    public DriverCategory forkliftDrivers = new DriverCategory();
    public MarketingManager marketingManager = new MarketingManager();


    // Stock categories
    public StockCategory landStocks = new StockCategory();
    public StockCategory inputMachineStocks = new StockCategory();
    public StockCategory outputMachineStocks = new StockCategory();
    public StockCategory commandStocks = new StockCategory();


    // Vehicle categories
    public VehicleCategory trucks = new VehicleCategory(landStocks, inputMachineStocks, truckDrivers);
    public VehicleCategory forklifts = new VehicleCategory(outputMachineStocks, commandStocks, forkliftDrivers);


    public MachineCategory machines = new MachineCategory();






    // Start threads
    // TODO Initialise all categories
    public Initialisation(){
        //== Example of company creation (everything is static)
        //FIXME: these information are placeholders for now.

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
                150000
        );

        //== Terminals creation
        //== These objects are SINGLETONS (they cannot be instantiated more than once)
        // Call this once
        Website website = Website.getInstance();
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
        MobileApp mobileApp = MobileApp.getInstance();
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


<<<<<<< HEAD
        //We create a new land with 2 woodcutters on it
        Land land = new Land(landStocks);
=======
        //We add two
>>>>>>> f8acaf648caabe522eadfb4e261207f446413c2c
        wcc.buy();
        wcc.buy();
        wcc.startWorking();


        Stock machineInputStock = new Stock();

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

<<<<<<< HEAD
        Driver truckDriver1 = new Driver(land.getStock(), machineInputStock, truck1,1);
=======
        Employee truckDriver1 = new Driver(forest.getStock(0), machineInputStock, truck1,1);
>>>>>>> f8acaf648caabe522eadfb4e261207f446413c2c
        truckDrivers.addEmployee(truckDriver1);
        truckDrivers.start();

        truck1.setDriver(truckDriver1);

        truckDriver1.startWorking();


        //== Machine part
        Stock machineOutputStock = new Stock();
        Machine machine = new Machine("Cute machine", 15, machineInputStock, machineOutputStock);
        machine.startWorking();


        //== Add one forklift to forkliftCategory
        Stock commandStock = new Stock();
        Vehicle forklift1 = new Forklift();

        Driver forkliftDriver1 = new Driver(machineOutputStock, commandStock, forklift1,1);
        forkliftDrivers.addEmployee(forkliftDriver1);
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
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
