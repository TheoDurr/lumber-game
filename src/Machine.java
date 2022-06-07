import java.util.List;

public class Machine extends Factory {

    private String name;

    private float price;

    public Machine(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void transformWood(Tree t) {
        if (t.getState() == TreeState.MATURE) {
            t.nextState();
        }
    }

}