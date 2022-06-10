public class MarketingManager extends Employee implements Runnable {

  private int speed;

  private Integer nbOfCustomersAttracted;

  private boolean isWorking;
  MarketingManager(int speed){
    this.speed = speed;
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
      Thread.sleep(10000/speed);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //Add the new client to the list of client of the entreprise to store them
  }

  @Override
  public void run() {
    while(isWorking){
      generateClient();
    }
  }
}