import vehiclePackage.Truck;
import vehiclePackage.Vehicle;
import vehiclePackage.VehicleCategory;

public class Main {
    public static void main(String[] args) {

        Vehicle testTruck = new Truck();
        VehicleCategory forestToFactoryTrucks = new VehicleCategory(testTruck);
        forestToFactoryTrucks.start();
    }
}
