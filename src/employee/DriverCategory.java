package employee;

import company.Company;
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

    public float getSalary(){
        float sumSalary=0;
        for(Employee driver : employees){
            sumSalary += ((Driver)driver).getSalary();
        }
        return sumSalary;
    }

    public void startWorking(){
        employees.forEach((driver)->((Driver)driver).startWorking());
    }

    public void stopWorking(){
        employees.forEach((driver)->((Driver)driver).stopWorking());
    }

    public int getNumber(){
        return employees.size();
    }

    public int getLevel(){
        return level;
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
    }
}
