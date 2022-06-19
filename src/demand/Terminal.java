package demand;

import company.Company;
import employee.PurchaseUpgrade;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class Terminal implements PurchaseUpgrade {

    private float creationCost;

    private float maintenanceCost;

    private List<Demand> demandList;

    private int maxDemands;

    private boolean isUnlocked;

    public Terminal() {
    }

    /**
     * This method initialize the new Terminal
     *
     * @param creationCost    cost subtracted at the unlocking
     * @param maintenanceCost cost subtracted each time
     * @param maxDemands      max capacity of the terminal (can be upgraded)
     */
    protected void init(float creationCost, float maintenanceCost, int maxDemands) {
        this.creationCost = creationCost;
        this.maintenanceCost = maintenanceCost;
        this.demandList = new ArrayList<>();
        this.maxDemands = maxDemands;
        this.isUnlocked = false;
    }

    /**
     * Checks if the terminal is unlocked
     *
     * @return true: unlocked - false: locked
     */
    public boolean isUnlocked() {
        return isUnlocked;
    }

    /**
     * Unlocks the terminal for the player by subtracting the creation cost
     */
    public void buy() {
        if (Company.pay(creationCost)) {
            this.isUnlocked = true;
        }
    }

    /**
     * This is the method to call to subtract each time maintenance cost of the terminal
     */
    public void maintain() {
        Company.pay(maintenanceCost);
    }

    /**
     * Refresh the terminal by removing pending and declined demands and adding new ones
     *
     * @return the count of new demands generated
     */
    public int refresh() {
        // We remove old demands
        demandList.removeIf(demand -> demand.getState() == DemandState.PENDING || demand.getState() == DemandState.DECLINED);

        // We generate new demands
        int newDemandsCount = maxDemands - demandList.size();
        for(int i = 0; i < newDemandsCount; i++){
            demandList.add(new Demand());
        }
        return newDemandsCount;
    }

    /**
     * Edit de demand's state from pending to be accepted
     * This demand needs to be completed
     *
     * @param demand
     */
    protected void acceptDemand(Demand demand) {
        if (demand.getState() == DemandState.PENDING) {
            demand.setState(DemandState.ACCEPTED);
        }
    }

    /**
     * Declines the specified demand
     * This removes it from the terminal
     *
     * @param demand
     */
    protected void declineDemand(Demand demand) {
        if (demand.getState() == DemandState.PENDING) {
            // NOTE: Demands which are declined can be visually removed from the list (some filtering on demand.getState())
            demand.setState(DemandState.DECLINED);
        }
    }

    /**
     * Completes the demand and pays the company
     *
     * @param demand
     * @return true : demand completed, false : demand cannot be completed
     */
    protected boolean completeDemand(Demand demand) {
        if (demand.getState() == DemandState.ACCEPTED && Company.getFinalStock().getCurrentCapacity() >= demand.getQuantity()) {
            demand.setState(DemandState.COMPLETED);
            Company.pay(demand.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public float getCreationCost() {
        return creationCost;
    }

    public float getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(float maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public List<Demand> getDemandList() {
        return demandList;
    }

    public int getMaxDemands() {
        return maxDemands;
    }

    public void setMaxDemands(int maxDemands) {
        this.maxDemands = maxDemands;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "demandList=" + demandList +
                '}';
    }
}