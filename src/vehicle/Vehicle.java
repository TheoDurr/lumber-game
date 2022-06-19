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
    wContent = stock.removeWood(capacity);
  }

  //Give wood to a stock
  public void dropWood(Stock stock) {
      stock.addWood(wContent);

  }


}