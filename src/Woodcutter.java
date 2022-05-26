public class Woodcutter extends Employee implements Runnable {
  private String name;

  private int speed;

  private int efficiency;

  private Land land;

  private Emplacement emplacement;

  public Woodcutter(String name, int speed, int efficiency){
    this.name = name;
    this.speed = speed;
    this.efficiency = efficiency;
  }

  public void setLand(Land l){
    land = l;
    emplacement = l.getRestEmplacement();
  }

  public void setEmplacement(Emplacement emp){
    emplacement.leaves();
    emplacement = emp;
    emplacement.arrives();
  }

  public void startWorking(){
    Thread t = new Thread(this);
    //this will call the method run (see below)
    t.start();
  }

  public void cutTree() {
    //We wait a certain amount of time depending on the speed of the worker
    try {
        Thread.sleep(1000/speed);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    //We change the state of the tree he just cut
    emplacement.getTree().nextState();

    //We add the tree to the stock associated to the land
    land.getStock().add(emplacement.getTree());

    //We remove the tree from this emplacement
    emplacement.removeTree();

    System.out.println(name+" has just cut a tree !");
  }

  @Override
  public void run() {
    //The woodcutter will go on a free emplacement where there is a tree that can be cut
    setEmplacement(land.getEmplacementForWC());
    
    if(emplacement!=null){
      cutTree();
    }
    else{
      System.out.printf("No emplacement with mature tree on it is free !");
    }
    
  }

}