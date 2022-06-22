import company.Company;
import demand.Customer;
import demand.MobileApp;
import demand.Website;
import employee.*;
import initialisation.Initialisation;
import interfaceGraphique.GraphicalInterface;
import terrain.Land;
import terrain.Machine;
import terrain.Stock;
import vehicle.Forklift;
import vehicle.Truck;
import vehicle.Vehicle;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Initialisation init = new Initialisation();


        //We create a new land with 2 woodcutters on it
        Land land = new Land();
        WoodcutterCategory wcc = new WoodcutterCategory();
        wcc.buy();
        wcc.buy();
        wcc.setLand(land);
        wcc.startWorking();


    }
}
