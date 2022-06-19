package terrain;

import wood.Wood;
import wood.Wood;

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

    public Stock(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        content = new ArrayList<Wood>();
    }


    public int getCurrentCapacity(){
        return content.size() ;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }


    public boolean isFull(){
        return content.size() == maxCapacity;
    }

    //Get a wood in argument
    //Add this wood to woodCapacity
    public void addWood(Wood w){
        content.add(w);
    }

    public void addWood(List<Wood> ws){

        // TODO checker que le nombre de bois ne dépasse pas la capacité du stock
        if(!this.isFull()){
            for(Wood w : ws){
                content.add(w);
            }
        }


    }

    //Return a list of wood
    //Remove this wood from the wood list of the stock
    public List<Wood> removeWood(int quantity){
        List<Wood> woodToRemove = new ArrayList<Wood>();

        for(int i = 0 ; i < quantity && i < this.getCurrentCapacity(); i++){
            woodToRemove.add(this.content.get(0));
            this.content.remove(0);
        }

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