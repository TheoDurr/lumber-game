import java.util.List;

public class Machine extends Factory {

    private String name;

    private float price;

    private Stock inputStock;
    private Stock outputStock;

    public Machine(String name, float price) {
        this.name = name;
        this.price = price;
        this.inputStock = new Stock();
        this.outputStock = new Stock();
    }

    public Stock getInputStock() {
        return inputStock;
    }

    public void setInputStock(Stock inputStock) {
        this.inputStock = inputStock;
    }

    public Stock getOutputStock() {
        return outputStock;
    }

    public void setOutputStock(Stock outputStock) {
        this.outputStock = outputStock;
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