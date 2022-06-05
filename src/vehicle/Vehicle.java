package vehicle;
import terrain.Stock;
import wood.Wood;

import java.util.List;

public abstract class Vehicle {

  protected String name;

  protected int level;

  protected int content = 0;
  protected List<Wood> wcontent;

  protected int capacity = 1;

  protected float max_speed;

  public abstract void retrieveWood(List<Wood> woodLoading, Stock stock);
  public abstract void dropWood(List<Wood> woodLoading, Stock stock);


}