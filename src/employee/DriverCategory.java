package employee;

import demand.Company;
import terrain.Stock;
import vehicle.Vehicle;

public class DriverCategory extends EmployeeCategory implements PurchaseUpgrade{

    private static final int PRICE_MULT = 100;
    private int level;



    public DriverCategory() {
        super();
        level = 1;
    }

    public void addDriver(Stock departureStock, Stock destinationStock, Vehicle vehicle){
        Driver d = new Driver(departureStock, destinationStock, vehicle,level);
    }

    @Override
    public void run(){
        while(true){
            ((Driver)employees.get(0)).drive();
            // TODO le sleep doit correspondre à la vitesse
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public float estimatePrice() {
        return (float) (PRICE_MULT*Math.pow(level,2));
    }

    @Override
    public void upgrade() {
        Company.pay(estimatePrice());
        level++;
        //For each element of woodcutters, we set the new speed
        employees.forEach( (driver) -> ((Driver)driver).levelUp(1));
    }

    @Override
    public void buy() {
        //comment on fait pour le vehicule ?
    }
}
