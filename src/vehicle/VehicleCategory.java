package vehicle;

import company.Company;
import employee.Driver;
import employee.DriverCategory;
import employee.EmployeeCategory;
import terrain.Machine;
import terrain.Stock;
import terrain.StockCategory;

import java.util.ArrayList;
import java.util.List;

public class VehicleCategory {
    private static final int PRICE_MULT = 100;

    private List<Vehicle> vehicles;

    private int level;

    StockCategory inputStocks = new StockCategory();
    StockCategory outputStocks = new StockCategory();

    DriverCategory drivers = new DriverCategory();


    public VehicleCategory(StockCategory inputStocks, StockCategory outputStocks, DriverCategory drivers){
        vehicles = new ArrayList<Vehicle>();
        this.inputStocks = inputStocks;
        this.outputStocks = outputStocks;
        this. drivers = drivers;
        level = 1;
        // TODO, inputStock, outputStock et categoryEmployee
    }

    public float estimatePrice() {
        return (float) (PRICE_MULT*Math.pow(level,2));
    }

    public void upgrade() {
        Company.pay(estimatePrice());
        level++;
        //For each element of woodcutters, we set the new speed
        vehicles.forEach( (vehicle) -> vehicle.levelUp(1));
    }

    public int getNumber(){
        return vehicles.size();
    }


    public int getLevel() {
        return level;
    }

    public void buy(){
        Vehicle vehicle = new Vehicle(getLevel());
        Driver driver = new Driver(inputStocks, outputStocks, vehicle,getLevel());

        //== Add one vehicle to VehicleCategory and start it
        drivers.addEmployee(driver);
        drivers.start();

        vehicle.setDriver(driver);

        driver.startWorking();

    }


}
