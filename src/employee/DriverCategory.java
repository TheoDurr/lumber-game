package employee;

import terrain.Stock;
import vehicle.Vehicle;

public class DriverCategory extends EmployeeCategory{


    public DriverCategory() {

        super();
    }

    public void addDriver(Stock departureStock, Stock destinationStock, Vehicle vehicle){
        Driver d = new Driver(departureStock, destinationStock, vehicle);
    }

    @Override
    public void run(){
        while(true){
            ((Driver)employees.get(0)).drive();
            // TODO le sleep doit correspondre à la vitesse
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
