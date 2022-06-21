package demand;

public class Customer {
    private String name;
    private String comment;

    /**
     * Default constructor for a customer (with description)
     *
     * @param name    the name of the customer
     * @param comment A description of it
     */
    public Customer(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    /**
     * Default constructor for a customer (without description)
     *
     * @param name the name of the customer
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * Fetches the name of the customer
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Fetches the comment of the customer
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }
}
