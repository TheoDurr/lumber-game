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

    public void unlock(){
        //TODO: find a way to ensure the company's balance is high enough, and subtract the creation cost
        this.isUnlocked = true;
    }

    /**
     * This generates randomly new demands
     */
    protected void refreshTerminal() {
    }

    /**
     * Generate a new random demand
     * @return the newly generated demand
     */
    protected Demand generateDemand() {
        // TODO: Implement random demand Generation
        return new Demand();
    }

    /**
     * Edit de demand's state from pending to be accepted
     * This demand needs to be completed
     *
     * @param demand
     */
    protected void acceptDemand(Demand demand) {
    }

    /**
     * Declines the specified demand
     * This removes it from the terminal
     *
     * @param demand
     */
    protected void declineDemand(Demand demand) {
    }

    protected boolean completeDemand(Demand d) {
        //TODO: Check if the demand can be completed, if not return false
        return true;
    }
/*
  protected void addDemand(Demand demand) {}

  protected void takeDemand(Demand demand) {}

  protected void completeDemand(Demand demand) {}
*/

}