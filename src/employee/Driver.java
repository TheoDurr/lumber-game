package employee;

import terrain.Stock;
import vehicle.Vehicle;

import java.util.Random;

public class Driver extends Employee implements Runnable {

  private boolean isWorking;
  //terrain.Stock where the wood is taken
  private Stock departureStock;

  //terrain.Stock where the wood is brought
  private Stock destinationStock;

  private Vehicle vehicle;

  private int level;
  private Random statGenerator;
  private int curSpeed;
  private int baseSpeed;
  private int speedGrowth;


  public Driver(Stock departureStock, Stock destinationStock, Vehicle vehicle,int level) {
    super();
    this.departureStock = departureStock;
    this.destinationStock = destinationStock;
    this.vehicle = vehicle;
    this.level = level;

    this.statGenerator = new Random();
    this.baseSpeed = statGenerator.nextInt(10);
    this.speedGrowth = statGenerator.nextInt(5)+2;
    this.setSalary(statGenerator.nextFloat()*500+1200);
    this.curSpeed = baseSpeed + speedGrowth*level;
    this.isWorking = false;
  }

  public void drive() {
    this.vehicle.retrieveWood(departureStock);

    try {
      Thread.sleep(timeToDrive());
    } catch (InterruptedException e) {}

    this.vehicle.dropWood(destinationStock);
  }

  private int timeToDrive(){
    return 10000/curSpeed;
  }

  @Override
  public void run() {
    while(isWorking){
      drive();
    }
  }

  public void levelUp(int lvl) {
    this.level += lvl;
    this.setSalary(this.getSalary()+statGenerator.nextFloat()*100);
    this.curSpeed = baseSpeed + speedGrowth*level;
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
}