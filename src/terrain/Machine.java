package terrain;

import terrain.Factory;
import terrain.Stock;
import wood.Plank;
import wood.Tree;
import wood.TreeState;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Machine extends Factory implements Runnable{

    private String name;

    private float price;

    private Stock inputStock;
    private Stock outputStock;

    public Machine(String name, float price, Stock inputStock, Stock outputStock) {
        this.name = name;
        this.price = price;
        this.inputStock = inputStock;
        this.outputStock = outputStock;
    }

    public Stock getInputStock() {
        return inputStock;
    }

    public void setInputStock(Stock inputStock) {
        this.inputStock = inputStock;
    }

    public Stock getOutputStock() {
        return outputStock;
    }

    public void setOutputStock(Stock outputStock) {
        this.outputStock = outputStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void transformTreeToPlank(Wood t) {

        List<Plank> planks = new ArrayList<Plank>();

        for(int i = 0 ;  i < 3 ; i++){
            planks.add(new Plank());
        }

        outputStock.addWood((ArrayList<Wood>)(List<?>) planks);
    }

    public void run(){

        while(true){
            // Transform tree into plank if there is wood in the stock
            if(inputStock.getCurrentCapacity()>0){
                transformTreeToPlank(inputStock.removeWood(1).get(0));
            }

            try {
                sleep(2500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void startWorking(){
        Thread t = new Thread(this);
        //this will call the method run (see below)
        t.start();
    }

}