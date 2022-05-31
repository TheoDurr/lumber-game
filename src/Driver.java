import terrain.Stock;
import vehicle.Vehicle;

public class Driver extends Employee {

  private Stock departureStock;
  private Stock destinationStock;

  private int speed;


  public void drive(Vehicle vehicle) {
    vehicle.retrieveWood(1, departureStock);
    vehicle.dropWood(1, destinationStock);
  }

  @Override
  public void getSalary() {

  }
}