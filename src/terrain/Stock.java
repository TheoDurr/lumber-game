package terrain;

import wood.Wood;

import java.util.List;

public class Stock {

    private int maxCapacity = 20; //Need to be changed
    private int currentCapacity = 0;
    private List<Wood> woodCapacity;

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

    //Get a list of wood in argument
    //Add this wood to woodCapacity
    public void addWood(int quantity){
        currentCapacity+=quantity;
    }

    //Return a list of wood
    //Remove this wood from the wood list of the stock
    public void removeWood(int quantity){
        currentCapacity-=quantity;
    }
}
