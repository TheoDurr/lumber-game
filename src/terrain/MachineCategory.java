package terrain;

import demand.Company;
import employee.PurchaseUpgrade;

import java.util.ArrayList;
import java.util.List;

public class MachineCategory implements PurchaseUpgrade {

    private static final int PRICE_MULT = 100;

    private List<Machine> machines;

    private int level;

    public MachineCategory(){
        machines = new ArrayList<Machine>();
        level = 1;
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
        machines.forEach( (machine) -> machine.levelUp(1));
    }

    @Override
    public void buy() {
        //TODO give it the same level as the other
        //machines.add(new Machine());
    }
}
