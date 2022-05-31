package vehicle;
import terrain.Stock;

public class Truck extends Vehicle {
    @Override
    public void retrieveWood(int quantity, Stock stock) {
        if(stock.getCurrentCapacity()>0){
            int woodQuantityToRemove = Math.min(this.capacity, stock.getCurrentCapacity());
            stock.removeWood(woodQuantityToRemove);
            this.content += woodQuantityToRemove;

        }
    }
    @Override
    public void dropWood(int quantity, Stock stock) {
        if( !stock.isFull() ){
            int stockQuantityOfEmptySpace = stock.getMaxCapacity() - stock.getCurrentCapacity();
            int woodQuantityToAdd = Math.min(this.capacity, stockQuantityOfEmptySpace);

            stock.addWood(woodQuantityToAdd);
            this.content -= woodQuantityToAdd;

        }
    }

}