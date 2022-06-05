package vehicle;
import terrain.Stock;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle {

    //Retrieve wood from a stock
    @Override
    public  void retrieveWood(List<Wood> woodLoading, Stock stock){
        if(stock.getCurrentCapacity()>0){
            int woodQuantityToRemove = Math.min(this.capacity, stock.getCurrentCapacity());
            //this.wcontent = stock.removeWood(woodQuantityToRemove);
        }
    }

    //Give wood to a stock
    @Override
    public void dropWood(List<Wood> woodLoading, Stock stock) {
        if( !stock.isFull() ){
            int stockQuantityOfEmptySpace = stock.getMaxCapacity() - stock.getCurrentCapacity();
            int woodQuantityToAdd = Math.min(this.capacity, stockQuantityOfEmptySpace);

            List<Wood> woodContentToAdd = new ArrayList<>();

            for(int i = 0 ; i < woodQuantityToAdd ; i++){
                woodContentToAdd.add(wcontent.get(0));
                wcontent.remove(0);
            }

            //stock.addWood(woodContentToAdd);

        }
    }

}