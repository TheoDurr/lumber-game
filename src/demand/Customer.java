package demand;

public class Customer {
    private String name;
    private String comment;

    public Customer(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
