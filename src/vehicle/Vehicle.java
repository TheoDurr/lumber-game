package vehicle;
import employee.Driver;
import employee.PurchaseUpgrade;
import terrain.Stock;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle implements PurchaseUpgrade {

  protected int level;

  protected List<Wood> wContent;

  protected int capacity;

  private Driver driver;

  public Vehicle(){
    this.level = 1;
    wContent = new ArrayList<Wood>();
  }

  // Set the driver associated to the vehicle
  public void setDriver(Driver driver){
    this.driver = driver;
  }

  //Retrieve wood from a stock
  public  void retrieveWood(Stock stock){
    this.wContent = stock.removeWood(capacity);
  }

  //Give wood to a stock
  public void dropWood(Stock stock) {
      stock.addWood(wContent);
  }

  public int getLevel(){
    return level;
  }
  public float estimatePrice(){
    return this.level*3;
  }

  public void upgrade(){
    this.levelUp(1);
  }

  public void buy(){

  }


  public abstract void levelUp(int lvl) ;
}