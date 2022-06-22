package employee;

import company.Company;
import terrain.Land;

import java.util.ArrayList;
import java.util.List;

public class WoodcutterCategory implements PurchaseUpgrade {


    private static final int PRICE_MULT = 100;

    private List<Woodcutter> woodcutters;
    private int level;





    public WoodcutterCategory() {
        woodcutters = new ArrayList<Woodcutter>();
        level = 1;
    }

    public void startWorking(){
        woodcutters.forEach((woodcutter)->woodcutter.startWorking());
    }

    public void setLand(Land l){
        woodcutters.forEach((woodcutter)->woodcutter.setLand(l));
    }

    public float getSalary(){
        float sumSalary=0;
        for(Woodcutter wc : woodcutters){
            sumSalary += wc.getSalary();
        }
        return sumSalary;
    }

    public int getNumber(){
        return woodcutters.size();
    }

    public int getLevel(){
        return level;
    }

    @Override
    public float estimatePrice() {
        return (float) (PRICE_MULT*Math.pow(level,2));
    }

    @Override
    public void upgrade() {
        Company.pay(estimatePrice());
        level++;
        //For each element of woodcutters, we set the new speed
        woodcutters.forEach( (woodcutter) -> woodcutter.levelUp(1));
    }

    @Override
    public void buy() {
        woodcutters.add(new Woodcutter(Integer.toString(woodcutters.size()),level,1));
    }
}
