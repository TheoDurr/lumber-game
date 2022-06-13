package demand;

public class Demand {
    private Boolean completed = false;
    private int quantity;
    private float price;

    private DemandState state = DemandState.PENDING;

    // TODO: add customer reference, when the customer class will be created

    public Demand(int quantity, float price) {
        this.quantity = quantity;
        this.price = price;
    }

    public DemandState getState() {
        return state;
    }

    public void setState(DemandState state) {
        this.state = state;
    }
}
