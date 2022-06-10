import java.util.Random;

public class Woodcutter extends Employee implements Runnable {
  private String name;

  //Speed at which the woodcutter is cutting the tree
  private int level;
  private int curSpeed;
  private int baseSpeed;
  private int speedGrowth;

  private Random statGenerator;

  private int efficiency;

  //Land on which the woodcutter work
  private Land land;

  //Specific emplacement on which the woodcutter is either cutting a tree or waiting for work
  private Emplacement emplacement;

  public Woodcutter(String name, int level, int efficiency){
    this.name = name;
    this.level = level;
    this.statGenerator = new Random();
    this.baseSpeed = statGenerator.nextInt(10);
    this.speedGrowth = statGenerator.nextInt(5)+2;
    this.setSalary(statGenerator.nextFloat()*500+1200);
    this.curSpeed = baseSpeed + speedGrowth*level;
    this.efficiency = efficiency;
  }

  public void levelUp(int lvl) {
    this.level += lvl;
    this.setSalary(this.getSalary()+statGenerator.nextFloat()*100);
    this.curSpeed = baseSpeed + speedGrowth*level;
  }

  public void setLand(Land l){
    land = l;
    //By default the wc will go in the rest emplacement
    emplacement = l.getRestEmplacement();
  }

  private void setEmplacement(Emplacement emp){
    emplacement.leaves();
    emplacement = emp;
  }

  public void startWorking(){
    Thread t = new Thread(this);
    //this will call the method run (see below)
    t.start();
  }

  private void cutTree() {
    //We wait a certain amount of time depending on the speed of the worker
    try {
        Thread.sleep(100000/curSpeed);
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
    while(emplacement.getType()==EmplacementType.TREE && !land.getStock().isFull()){
      cutTree();
      setEmplacement(land.getEmplacementForWC());
    }
    
    System.out.printf(name+" has no emplacement with mature tree on it and that is free !\n");
    
    
  }

}