import terrain.Stock;

public class Main {
    public static void main(String[] args) {

        Stock startingTestStock = new Stock();
        Stock endingTestStock = new Stock();

        startingTestStock.addWood(5);
        endingTestStock.addWood(5);

        Employee driver1 = new Driver();
        EmployeeCategory drivers = new EmployeeCategory(driver1);
        drivers.start();

    }
}
