package demand;

import company.Company;
import employee.PurchaseUpgrade;

import java.util.ArrayList;
import java.util.List;

public abstract class Terminal implements PurchaseUpgrade {

    private final float creationCost;

    private float maintenanceCost;

    private List<Demand> demandList;

    private int maxDemands;

    private boolean isUnlocked;


    /**
     * Default constructor for the Terminal
     *
     * @param creationCost    cost subtracted at the unlocking
     * @param maintenanceCost cost subtracted each time
     * @param maxDemands      max capacity of the terminal (can be upgraded)
     */
    public Terminal(float creationCost, float maintenanceCost, int maxDemands) {
        this.creationCost = creationCost;
        this.maintenanceCost = maintenanceCost;
        this.demandList = new ArrayList<>();
        this.maxDemands = maxDemands;
        this.isUnlocked = false;
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
     * This generates randomly new demands
     */
    protected void refreshTerminal() {
    }

    /**
     * Generate a new random demand
     *
     * @return the newly generated demand
     */
    protected Demand generateDemand() {
        // TODO: Implement random demand Generation
        // FIXME: This is a sample demand
        return new Demand(
                5,
                2500,
                new Customer("Jean"));
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
}