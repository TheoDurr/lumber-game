package vehicle;
import terrain.Stock;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle {

    public Truck(){
        super();
        capacity = 10;
    }

    public void levelUp(int lvl){
        level++;
        capacity += 3;
    }
    @Override
    public int getLevel() {
        return super.getLevel();
    }


}