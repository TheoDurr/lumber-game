package employee;

import java.util.Random;

public class MarketingManager extends Employee implements Runnable, PurchaseUpgrade {

  private static final int PRICE_MULT = 500;
  private int curSpeed;
  private int baseSpeed;
  private int speedGrowth;

  private Random statGenerator;

  private int level;

  private Integer nbOfCustomersAttracted;

  private boolean isWorking;

  public MarketingManager(){
    this.level = 1;
    this.statGenerator = new Random();
    this.baseSpeed = statGenerator.nextInt(10);
    this.speedGrowth = statGenerator.nextInt(5)+2;
    this.setSalary(statGenerator.nextFloat()*500+1500);
    this.curSpeed = baseSpeed + speedGrowth*level;

  }
  MarketingManager(int speed){
    this.curSpeed = speed;
    isWorking = false;
  }
  public void startWorking(){
    isWorking = true;
    Thread t = new Thread(this);
    //this will call the method run (see below)
    t.start();
  }

  public void generateClient(){
    try {
      Thread.sleep(100000/curSpeed);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //Add the new client to the list of client of the entreprise to store them
  }

  public void levelUp(int lvl){
    level+=lvl;
    curSpeed += speedGrowth*lvl;
  }

  @Override
  public void run() {
    while(isWorking){
      generateClient();
    }
  }

  @Override
  public float estimatePrice() {
    return (float) (PRICE_MULT*Math.pow(level,2));
  }

  @Override
  public void upgrade() {
    //company.Company.pay(estimatePrice());
    levelUp(1);
  }

  @Override
  public void buy() {

  }
}