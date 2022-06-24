package terrain;

import company.Company;
import employee.MachinePurchaseUpgrade;
import employee.PurchaseUpgrade;

import java.util.ArrayList;
import java.util.List;

public class MachineCategory implements MachinePurchaseUpgrade {

    private static final int PRICE_MULT = 100;

    private List<Machine> machines;

    private int level;

    public MachineCategory() {
        machines = new ArrayList<Machine>();
        level = 1;
    }

    public int getNumber() {
        return machines.size();
    }

    public int getLevel() {
        return level;
    }

    /**
     * Estimate the upgrade price
     *
     * @return the estimated price
     */
    @Override
    public float estimatePrice() {
        return (float) (PRICE_MULT * Math.pow(level, 2));
    }

    /**
     * Upgrades the machine
     */
    @Override
    public void upgrade() {
        if(Company.pay(estimatePrice())){
            level++;
            //For each element of machine, we set the new speed
            machines.forEach((machine) -> machine.levelUp(1));
        }

    }

    /**
     * Adds a new machine
     *
     * @param inputStock  the input stock of the machine
     * @param outputStock the output stock of the machine
     */
    public void buy(StockCategory inputStock, StockCategory outputStock) {
        Stock machineInputStock = new Stock(inputStock.getLevel());
        inputStock.addStock(machineInputStock);
        Stock machineOutputStock = new Stock(outputStock.getLevel());
        outputStock.addStock(machineOutputStock);

        machines.add(new Machine(Integer.toString(getNumber()), level, machineInputStock, machineOutputStock));
        System.out.println("Machine bought");
    }
}
