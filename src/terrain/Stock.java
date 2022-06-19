package terrain;

import wood.Wood;
import wood.Wood;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Stock {
    private int maxCapacity;

    private List<Wood> content;

    private int level;

    public Stock(){
        maxCapacity = 20;
        content = new ArrayList<Wood>();
    }



    public int getMaxCapacity(){
        return maxCapacity;
    }

    // Only for display purpose, to know if the stock is full or empty use isFull or isEmpty
    public int getCurrentCapacity(){
        return this.content.size();
    }

    public boolean isFull(){
        return content.size() == maxCapacity;
    }

    public boolean isEmpty(){
        return this.content.size() == 0;
    }

    //Get a wood in argument
    //Add this wood to woodCapacity
   synchronized public void addWood(Wood w){
        List <Wood> ws = new ArrayList<>();
        ws.add(w);
        addWood(ws);
    }


    // Add wood if the stock is not full. Otherwise, wait
    synchronized public void addWood(List<Wood> ws) {

        for(Wood w : ws){

            while(this.isFull()){
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            content.add(w);
            notifyAll();

        }

    }

    //Return a list of wood
    //Remove this wood from the wood list of the stock
    synchronized public List<Wood> removeWood(int quantity){
        List<Wood> woodToRemove = new ArrayList<Wood>();

        for(int i = 0 ; i < quantity && i < this.content.size(); i++){
            woodToRemove.add(this.content.get(0));
            this.content.remove(0);
        }
        notifyAll();
        return woodToRemove;
    }


    public String toString(){
        String str = content.size()+"/"+maxCapacity+"\n";
        Iterator<Wood> it = content.iterator();
        while(it.hasNext()){
            str+=" -"+it.next().toString();
            it.remove();
        }
        return str;
    }

    public void levelUp(int lvl) {
        this.level += lvl;
        maxCapacity += Math.round(this.level/3);
    }
}