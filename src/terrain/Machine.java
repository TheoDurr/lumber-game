package terrain;

import terrain.Factory;
import terrain.Stock;
import wood.Plank;
import wood.Tree;
import wood.TreeState;
import wood.Wood;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Machine extends Factory implements Runnable{

    private String name;

    private float price;

    private boolean isWorking;

    private int level;

    private int curSpeed;
    private int baseSpeed;
    private int speedGrowth;

    private Random statGenerator;

    private Stock inputStock;
    private Stock outputStock;

    public Machine(String name, float price, Stock inputStock, Stock outputStock,int level) {
        this.name = name;
        this.isWorking = false;
        this.price = price;
        this.inputStock = inputStock;
        this.outputStock = outputStock;
        this.level = level;
        this.statGenerator = new Random();
        this.baseSpeed = statGenerator.nextInt(10);
        this.speedGrowth = statGenerator.nextInt(5)+2;
        this.curSpeed = baseSpeed + speedGrowth*level;
    }

    public Machine(String name){
        this.name = name;
        this.isWorking = false;
        this.price = 0;
        this.level = 1;
        this.inputStock = new Stock();
        this.outputStock = new Stock();

        this.statGenerator = new Random();
        this.baseSpeed = statGenerator.nextInt(10);
        this.speedGrowth = statGenerator.nextInt(5)+2;
        this.curSpeed = baseSpeed + speedGrowth*level;
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

        while(isWorking){
            // Transform tree into plank if there is wood in the stock

            transformTreeToPlank(inputStock.removeWood(1).get(0));


            try {
                sleep(2500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void startWorking(){
        isWorking = true;
        Thread t = new Thread(this);
        //this will call the method run (see below)
        t.start();
    }

    public void stopWorking(){
        isWorking = false;
    }

    public void levelUp(int lvl){
        level+= lvl;
        curSpeed += lvl * speedGrowth;
    }

}