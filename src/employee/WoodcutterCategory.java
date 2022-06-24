package employee;

import company.Company;
import terrain.Forest;
import terrain.Land;

import java.util.ArrayList;
import java.util.List;

public class WoodcutterCategory extends EmployeeCategory implements PurchaseUpgrade {


    private static final int PRICE_MULT = 100;
    private int level;

    private Forest forest;


    public WoodcutterCategory() {
        super();
        level = 1;
    }

    public WoodcutterCategory(Forest forest) {
        this();
        this.forest = forest;
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
            sumSalary += wc.getSalary();
        }
        return sumSalary;
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
        if(Company.pay(estimatePrice())){
            level++;
            //For each element of woodcutters, we set the new speed
            employees.forEach( (woodcutter) -> ((Woodcutter)woodcutter).levelUp(1));
        }

    }

    @Override
    public void buy() {
        Woodcutter wc = new Woodcutter(Integer.toString(employees.size()),level);
        Land landToSet = forest.getLandFewestWC();
        System.out.println("2WoddcutterCat, forest land size : " + forest.getLands().size());

        landToSet.newWoodcutter();
        //We set the land with the fewest woodcutter on it
        wc.setLand(landToSet);
        wc.startWorking();
        employees.add(wc);
    }
}
