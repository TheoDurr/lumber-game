package demand;

import java.util.ArrayList;
import java.util.List;

public abstract class Terminal {

    private float creationCost;

    private float maintenanceCost;

    private List<Demand> demandList;

    private int maxDemands;

    private boolean isUnlocked;


    public Terminal(float creationCost, float maintenanceCost, int maxDemands) {
        this.creationCost = creationCost;
        this.maintenanceCost = maintenanceCost;
        this.demandList = new ArrayList<Demand>();
        this.maxDemands = maxDemands;
        this.isUnlocked = false;
    }

    public void unlock() {
        //TODO: find a way to ensure the company's balance is high enough, and subtract the creation cost, this can be done once the company is declared as static
        this.isUnlocked = true;
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
        return new Demand(5, 2500);
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
            // TODO: Demands which are declined can be removed from the list
            demand.setState(DemandState.DECLINED);
        }
    }

    protected boolean completeDemand(Demand demand) {
        //TODO: Check if the demand can be completed, if not return false
        if (demand.getState() == DemandState.ACCEPTED) {
            // TODO: Check the stock, but the stock reference is missing, maybe the final stockpile can be static
            return true;
        } else {
            return false;
        }
    }
}