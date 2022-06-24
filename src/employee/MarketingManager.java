package employee;

import company.Company;
import demand.Terminal;
import demand.TerminalSingleton;

import java.util.Random;

public class MarketingManager extends Employee implements PurchaseUpgrade {

    private static final int PRICE_MULT = 500;
    private int level = 1;
    private float creationCost;
    private float maintenanceCost;
    private Terminal website;
    private Terminal mobileApp;

    public MarketingManager(float creationCost, float maintenanceCost, Terminal website, Terminal mobileApp) {
        this.creationCost = creationCost;
        this.maintenanceCost = maintenanceCost;
        this.website = website;
        this.mobileApp = mobileApp;
    }

    public int getLevel() {
        return level;
    }

    public float getCreationCost() {
        return creationCost;
    }


    public float getMaintenanceCost() {
        return maintenanceCost;

    private void levelUp(int lvl) {
        level += lvl;
    }

    @Override
    public float estimatePrice() {
        return (float) (PRICE_MULT * Math.pow(level, 2));
    }

    @Override
    public void upgrade() {
        Company.pay(estimatePrice());
        website.upgrade();
        mobileApp.upgrade();
        levelUp(1);
    }

    @Override
    public void buy() {
        Company.pay(creationCost);
    }
}