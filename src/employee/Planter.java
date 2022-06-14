package employee;
import terrain.Emplacement;
import terrain.EmplacementType;
import terrain.Land;
import wood.Tree;
import wood.TreeState;

import java.util.Random;

public class Planter extends Employee implements Runnable {

  private String name;

  //Speed at which the woodcutter is cutting the tree
  private int level;
  private int curSpeed;
  private int baseSpeed;
  private int speedGrowth;

  private Random statGenerator;

  private int efficiency;
  private Land land;

  //Specific emplacement on which the planter is either planting a tree or waiting for work
  private Emplacement emplacement;


  Planter(String name, int level, int efficiency){
    this.name = name;
    this.level = level;
    this.statGenerator = new Random();
    this.baseSpeed = statGenerator.nextInt(10);
    this.speedGrowth = statGenerator.nextInt(5)+2;
    this.setSalary(statGenerator.nextFloat()*500+1200);
    this.curSpeed = baseSpeed + speedGrowth*level;
    this.efficiency = efficiency;
  }

  public void startWorking(){
    Thread t = new Thread(this);
    //this will call the method run (see below)
    t.start();
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

  public void setEmplacement(Emplacement emp){
    emplacement.leaves();
    emplacement = emp;
  }
  public void plantTree() {
    //We wait a certain amount of time depending on the speed of the worker
    try {
      Thread.sleep(100000/curSpeed);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    Tree t = new Tree(TreeState.MATURE);
    emplacement.plantTree(t);
    System.out.println(name+" has just plant a tree !");
  }

  @Override
  public void run() {
    //The planter will go on a free emplacement where there is no tree on it
    setEmplacement(land.getEmplacementForP());
    while(emplacement.getType()== EmplacementType.TREE){
      plantTree();
      setEmplacement(land.getEmplacementForP());
    }

    System.out.printf(name+" has no emplacement with no tree on it and that is free !\n");

  }
}