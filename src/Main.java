import terrain.Stock;
import vehicle.Truck;
import vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {


        Stock startingTestStock = new Stock();
        Stock endingTestStock = new Stock();
        Vehicle truck1 = new Truck();

        startingTestStock.addWood(5);
        endingTestStock.addWood(5);

        System.out.println("Stock de départ nombre de troncs : " + startingTestStock.getCurrentCapacity());
        System.out.println("Stock d'arrivée nombre de troncs : " + endingTestStock.getCurrentCapacity());
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
        System.out.println("Stock de départ nombre de troncs : " + startingTestStock.getCurrentCapacity());
        System.out.println("Stock d'arrivée nombre de troncs : " + endingTestStock.getCurrentCapacity());

    }
}
