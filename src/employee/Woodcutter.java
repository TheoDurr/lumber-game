package employee;

import terrain.Emplacement;
import terrain.Land;

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
  private
  Land land;

  //Specific emplacement on which the woodcutter is either cutting a tree or waiting for work
  private Emplacement emplacement;

  private boolean isWorking;

  public Woodcutter(String name, int level, int efficiency){
    this.name = name;
    this.level = level;
    this.statGenerator = new Random();
    this.baseSpeed = statGenerator.nextInt(10);
    this.speedGrowth = statGenerator.nextInt(5)+2;
    this.setSalary(statGenerator.nextFloat()*500+1200);
    this.curSpeed = baseSpeed + speedGrowth*level;
    this.efficiency = efficiency;
    this.isWorking = false;
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
    emplacement = emp;
  }

  public void startWorking(){
    if(!isWorking){
      Thread t = new Thread(this);
      isWorking = true;
      t.start();
    }
  }

  public void stopWorking(){
    isWorking = false;
  }

  private void cutTree() {
    //We wait a certain amount of time depending on the speed of the worker
    try {
        Thread.sleep(50000/curSpeed);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    //We change the state of the tree he just cut
    emplacement.getTree().nextState();

    //We add the tree to the stock associated to the land
    land.getStock().addWood(emplacement.getTree());

    //We remove the tree from this emplacement
    emplacement.removeTree();

    //The woodcutter can now leave his emplacement
    emplacement.leaves();
    synchronized (land){
      land.notifyAll();

    }
    setEmplacement(land.getRestEmplacement());

    System.out.println(name+" has just cut a tree !");
  }

  @Override
  public void run() {

    while(isWorking){
      //The woodcutter will go on a free emplacement where there is a tree that can be cut
      //The woodcutter ask the shared object (land) for work to do (The shared object (land) will handle the synchronisation of threads)
      setEmplacement(land.getEmplacementForWC());
      cutTree();
    }
    
    System.out.printf(name+" stops working !\n");

  }
}