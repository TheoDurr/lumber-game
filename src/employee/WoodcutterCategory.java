package employee;

import demand.Company;
import terrain.Land;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public class WoodcutterCategory extends EmployeeCategory implements PurchaseUpgrade {


    private static final int PRICE_MULT = 100;
    private int level;




    public WoodcutterCategory() {
        super();
        level = 1;
    }

    public void startWorking(){
        employees.forEach((woodcutter)->((Woodcutter)woodcutter).startWorking());
    }

    public void setLand(Land l){
        employees.forEach((woodcutter)->((Woodcutter)woodcutter).setLand(l));
    }

    public float getSalary(){
        float sumSalary=0;
        for(Employee wc : employees){
            sumSalary += ((Woodcutter)wc).getSalary();
        }
        return sumSalary;
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
        employees.forEach( (woodcutter) -> ((Woodcutter)woodcutter).levelUp(1));
    }

    @Override
    public void buy() {
        employees.add(new Woodcutter(Integer.toString(employees.size()),level,1));
    }
}
