package vehiclePackage;

import java.util.ArrayList;

public class VehicleCategory extends Thread{
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public VehicleCategory(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void run() {
        System.out.println("A");
        System.out.println("B");
    }

}
