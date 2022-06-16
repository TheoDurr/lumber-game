package vehicle;
import terrain.Stock;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

  protected String name;

  protected int level;

  protected List<Wood> wContent = new ArrayList<Wood>();

  protected int capacity = 1;

  protected float max_speed;

  //Retrieve wood from a stock
  public  void retrieveWood(Stock stock){
    if(stock.getCurrentCapacity()>0 && wContent.size() <= capacity){
      int woodQuantityToRemove = Math.min(this.capacity, stock.getCurrentCapacity());
      this.wContent = stock.removeWood(woodQuantityToRemove);
    }
  }

  //Give wood to a stock
  public void dropWood(Stock stock) {
    if( !stock.isFull() && this.wContent.size() != 0){
      int stockQuantityOfEmptySpace = stock.getMaxCapacity() - stock.getCurrentCapacity();
      int woodQuantityToAdd = Math.min(this.capacity, stockQuantityOfEmptySpace);

      List<Wood> woodContentToAdd = new ArrayList<>();

      for(int i = 0 ; i < woodQuantityToAdd ; i++){
        woodContentToAdd.add(wContent.get(0));
        wContent.remove(0);
      }

      stock.addWood(woodContentToAdd);
    }
  }


}