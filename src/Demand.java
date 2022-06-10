import java.util.Random;

public class Demand {
    private int quantity;

    private float price;

    private Random random;

    Demand(){
        random = new Random();
        quantity = random.nextInt(50)+10;
        price = random.nextFloat()*20+10;
    }

    public String toString(){
        return "-"+quantity+" planks for "+price+ " the unit.";
    }
}
