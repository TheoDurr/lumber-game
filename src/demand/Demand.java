package demand;


import company.Company;

import java.util.Random;

public class Demand {
    //=======Static variables used for balancing =======//
    private static final int baseMinimumPlankCount = 1;
    private static final int baseMaximumPlankCount = 10;

    private static final double minimumPriceMultiplier = 0.9;
    private static final double maximumPriceMultiplier = 2;

    private static final double basePlankPrice = 1500;

    private final int quantity;
    private final float price;
    private final Customer customer;
    private DemandState state = DemandState.PENDING;

    /**
     * This is the constructor to create custom demands
     *
     * @param quantity the quantity of wood needed to achieve the contract
     * @param price    the money gifted for this contract
     * @param customer the customer asking for this contract
     */
    public Demand(int quantity, float price, Customer customer) {
        this.quantity = quantity;
        this.price = price;
        this.customer = customer;
    }

    /**
     * Returns a randomly generated demand
     */
    public Demand() {
        Random random = new Random();
        int customerBookLength = Company.getCustomerBook().length;

        this.quantity = (int) (Math.random() * (baseMaximumPlankCount - baseMinimumPlankCount + 1)) + baseMinimumPlankCount;
        this.price = (float) ((Math.random() * (maximumPriceMultiplier - minimumPriceMultiplier)) + minimumPriceMultiplier * this.quantity * basePlankPrice);
        this.customer = Company.getCustomerBook()[random.nextInt(customerBookLength)];
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public DemandState getState() {
        return state;
    }

    public void setState(DemandState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", customer=" + customer +
                ", state=" + state +
                '}';
    }
}
