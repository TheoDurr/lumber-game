import terrain.Stock;
import vehicle.Vehicle;

import static java.lang.Thread.sleep;

public class Driver extends Employee {

  //terrain.Stock where the wood is taken
  private Stock departureStock;

  //terrain.Stock where the wood is brought
  private Stock destinationStock;

  private Vehicle vehicle;

  private int speed;

  public Driver(Stock departureStock, Stock destinationStock, Vehicle vehicle) {
    super();
    this.departureStock = departureStock;
    this.destinationStock = destinationStock;
    this.vehicle = vehicle;
  }

  public void drive() {
    this.vehicle.retrieveWood(departureStock);
    this.vehicle.dropWood(destinationStock);
  }

  @Override
  public void getSalary() {

  }
}