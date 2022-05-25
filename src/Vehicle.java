public abstract class Vehicle {

  private String name;

  private enum type{
    TREE_SPROUT,
    MATURE_TREE,
    CUT_TREE
  };

  private int level;

  private int capacity;

  private int inventory;

  private float max_speed;

  public void retrieveWood(int quantity) {
  }

  public void dropWood(int quantity) {
  }


}