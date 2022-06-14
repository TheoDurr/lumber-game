package demand;

public class Demand {
    private Boolean completed = false;
    private int quantity;
    private float price;

    private DemandState state = DemandState.PENDING;

    private Customer customer;

    // TODO: add customer reference, when the customer class will be created

    public Demand(int quantity, float price, Customer customer) {
        this.quantity = quantity;
        this.price = price;
        this.customer = customer;
    }

    public DemandState getState() {
        return state;
    }

    public void setState(DemandState state) {
        this.state = state;
    }
}
