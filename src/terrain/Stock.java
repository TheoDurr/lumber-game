package terrain;

public class Stock {

    private int maxCapacity = 20; //Need to be changed
    private int currentCapacity = 0;

    public int getCurrentCapacity(){
        return currentCapacity;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public boolean isFull(){
        if(currentCapacity == maxCapacity){
            return true;
        }
        return false;
    }

    public void addWood(int quantity){
        currentCapacity+=quantity;


    }

    public void removeWood(int quantity){
        currentCapacity-=quantity;
    }
}
