package demand;

import company.Company;
import employee.PurchaseUpgrade;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class Terminal implements PurchaseUpgrade, Runnable {

    private float creationCost;

    private float maintenanceCost;

    private List<Demand> demandList;

    private boolean isUnlocked;

    //=== Level and upgrade related
    private static int level;
    private static int maxDemands;

    //=== Thread variables
    private Thread thread;
    private int refreshDelay;
    private boolean threadContinue;

    public Terminal() {
    }

    /**
     * This method initialize the new Terminal
     *
     * @param creationCost    cost subtracted at the unlocking
     * @param maintenanceCost cost subtracted each time
     * @param maxDemands      max capacity of the terminal (can be upgraded)
     * @param refreshDelay    the milliseconds between two demand updates
     */
    protected void init(float creationCost, float maintenanceCost, int maxDemands, int refreshDelay) {
        this.creationCost = creationCost;
        this.maintenanceCost = maintenanceCost;
        this.demandList = new ArrayList<>();
        Terminal.maxDemands = maxDemands;
        this.isUnlocked = false;
        this.refreshDelay = refreshDelay;
        Terminal.level = 1;

        this.thread = new Thread();
        this.thread.start();
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
     * Upgrades the Terminal and subtract the upgrade price from the company cash flow
     *
     * @see Company
     */
    public void upgrade() {
        Company.pay(this.estimatePrice());
        levelUp();
    }

    /**
     * Increase the level of the Terminal
     * This level up increase the max demands by 1
     */
    private void levelUp() {
        level++;
        maxDemands++;
        refreshDelay /= 1.2;
    }

    /**
     * Compute the upgrade price
     *
     * @return the upgrade price
     */
    public float estimatePrice() {
        return (float) (creationCost * level * 1.5);
    }

    /**
     * This is the method to call to subtract each time maintenance cost of the terminal
     */
    public void maintain() {
        Company.pay(maintenanceCost);
    }

    /**
     * Refresh the terminal by removing pending, declined and completed demands and adding new ones
     *
     * @return the count of new demands generated
     */
    public int refresh() {
        // We remove old demands
        demandList.removeIf(demand -> demand.getState() == DemandState.PENDING || demand.getState() == DemandState.DECLINED || demand.getState() == DemandState.COMPLETED);

        // We generate new demands
        int newDemandsCount = maxDemands - demandList.size();
        for (int i = 0; i < newDemandsCount; i++) {
            demandList.add(new Demand());
        }
        return newDemandsCount;
    }

    /**
     * Edit de demand's state from pending to be accepted
     * This demand needs to be completed
     *
     * @param demand the demand to be accepted
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
     * @param demand the demand to be declined
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
     * @param demand the demand to be completed
     * @return true : demand completed, false : demand cannot be completed
     */
    protected boolean completeDemand(Demand demand) {
        if (demand.getState() == DemandState.ACCEPTED && Company.getFinalStock().getCurrentCapacity() >= demand.getQuantity()) {
            Company.getFinalStock().removeWood(demand.getQuantity());
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

    public void run() {
        threadContinue = true;
        while (threadContinue) {
            try {
                Thread.sleep(refreshDelay);
                this.refresh();
            } catch (InterruptedException ignored) {
                System.out.println("Refreshed");
            }
        }
    }

    public void pause() {
        threadContinue = false;
    }

    public void resume() {
        threadContinue = true;
    }

    @Override
    public String toString() {
        return "Terminal{" + "demandList=" + demandList + '}';
    }
}