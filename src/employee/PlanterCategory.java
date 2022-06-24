package employee;

import company.Company;
import terrain.Forest;
import terrain.Land;

public class PlanterCategory extends EmployeeCategory implements PurchaseUpgrade {

    private static final int PRICE_MULT = 10;
    private static final int MAX_LVL = 100;

    private int level;

    private Forest forest;


    public PlanterCategory() {
        super();
        level = 1;
    }

    public PlanterCategory(Forest forest) {
        this();
        this.forest = forest;
    }

    public void startWorking() {
        employees.forEach((planter) -> ((Planter) planter).startWorking());
    }

    public void setLand(Land l) {
        employees.forEach((planter) -> ((Planter) planter).setLand(l));
    }

    public float getSalary() {
        float sumSalary = 0;
        for (Employee p : employees) {
            sumSalary += p.getSalary();
        }
        return sumSalary;
    }

    public int getNumber() {
        return employees.size();
    }

    public int getLevel() {
        return level;
    }

    @Override
    public float estimatePrice() {
        return (float) (PRICE_MULT * Math.pow(level, 2));
    }

    @Override
    public void upgrade() {
        if (level < MAX_LVL) {
            Company.pay(estimatePrice());
            level++;
            //For each element of woodcutters, we set the new speed
            employees.forEach((planter) -> ((Planter) planter).levelUp(1));
        }
    }

    @Override
    public void buy() {
        Planter planter = new Planter(Integer.toString(employees.size()), level);
        Land landToSet = forest.getLandFewestWC();
        landToSet.newPlanter();
        //We set the land with the fewest woodcutter on it
        planter.setLand(landToSet);
        planter.startWorking();
        employees.add(planter);
    }
}
