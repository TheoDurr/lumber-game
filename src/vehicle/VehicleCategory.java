package vehicle;

import company.Company;
import terrain.Machine;

import java.util.ArrayList;
import java.util.List;

public class VehicleCategory {
    private static final int PRICE_MULT = 100;

    private List<Vehicle> vehicles;

    private int level;


    public VehicleCategory(){
        vehicles = new ArrayList<Vehicle>();
        level = 1;
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

    }
}
