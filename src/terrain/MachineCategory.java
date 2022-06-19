package terrain;

import demand.Company;
import employee.PurchaseUpgrade;

import java.util.ArrayList;
import java.util.List;

public class MachineCategory implements PurchaseUpgrade {
    private List<Machine> machines;

    private int level;

    MachineCategory(){
        level = 1;
        machines = new ArrayList<>();
        machines.add(new Machine("Initial Machine",120f,new Stock(),new Stock(),level));
    }

    @Override
    public float estimatePrice() {
        return 0;
    }

    @Override
    public void upgrade() {
        Company.pay(estimatePrice());
        level++;
        machines.forEach((machine -> machine.levelUp(1)));
    }

    @Override
    public void buy() {
        machines.add(new Machine("Additional Machine",120f,new Stock(),new Stock(),level));
    }

    public void startWorking(){
        machines.forEach((machine -> machine.startWorking()));
    }

    public void stopWorking(){
        machines.forEach((machine -> machine.stopWorking()));
    }
}
