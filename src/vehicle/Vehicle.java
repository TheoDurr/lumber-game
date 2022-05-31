package vehicle;
import terrain.Stock;

public abstract class Vehicle {

  protected String name;

  protected int level;

  protected int maxCapacity;

  protected int capacity;

  protected float max_speed;

  public abstract void retrieveWood(int quantity, Stock stock);
  public abstract void dropWood(int quantity, Stock stock);


}