import terrain.Stock;
import vehicle.Vehicle;

public class Driver extends Employee {

  //Stock where the wood is taken
  private Stock departureStock;

  //Stock where the wood is brought
  private Stock destinationStock;

  private Vehicle vehicle;

  private int speed;

  // TODO remove
  public Driver(){
    super();
  }
  public Driver(Stock departureStock, Stock destinationStock, Vehicle vehicle) {
    super();
    this.departureStock = departureStock;
    this.destinationStock = destinationStock;
    this.vehicle = vehicle;
  }


  public void drive() {
    //this.vehicle.retrieveWood(1, departureStock);
    //this.vehicle.dropWood(1, destinationStock);
  }

  @Override
  public void getSalary() {

  }
}