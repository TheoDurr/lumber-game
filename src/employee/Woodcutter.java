package employee;


import terrain.Emplacement;
import terrain.EmplacementType;
import terrain.Land;
import wood.Wood;

import java.util.List;

public class Woodcutter extends Employee implements Runnable {
  private String name;

  //Speed at which the woodcutter is cutting the tree
  private int speed;

  private int efficiency;

  //Land on which the woodcutter work
  private
  Land land;

  //Specific emplacement on which the woodcutter is either cutting a tree or waiting for work
  private Emplacement emplacement;

  public Woodcutter(String name, int speed, int efficiency){
    this.name = name;
    this.speed = speed;
    this.efficiency = efficiency;
  }

  public void setLand(Land l){
    land = l;
    //By default the wc will go in the rest emplacement
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
        Thread.sleep(5000/speed);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    //We change the state of the tree he just cut
    emplacement.getTree().nextState();

    //We add the tree to the stock associated to the land
    land.getStock().addWood(emplacement.getTree());
    System.out.println("Land stock number of trunks : " + land.getStock().getCurrentCapacity());


    //We remove the tree from this emplacement
    emplacement.removeTree();

    System.out.println(name+" has just cut a tree !");
  }

  @Override
  public void run() {
    //The woodcutter will go on a free emplacement where there is a tree that can be cut
    setEmplacement(land.getEmplacementForWC());
    while(emplacement.getType()== EmplacementType.TREE){
      cutTree();
      setEmplacement(land.getEmplacementForWC());
    }
    
    System.out.printf(name+" has no emplacement with mature tree on it and that is free !\n");
    
    
  }

  @Override
  public void getSalary() {

  }
}