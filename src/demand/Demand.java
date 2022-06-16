package demand;

public class Demand {
    private final int quantity;
    private final float price;

    private DemandState state = DemandState.PENDING;
    private final Customer customer;

    public Demand(int quantity, float price, Customer customer) {
        this.quantity = quantity;
        this.price = price;
        this.customer = customer;
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
}
