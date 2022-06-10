import java.util.ArrayList;
import java.util.List;

public class PlanterCategory implements PurchaseUpgrade{

    private static final int PRICE_MULT = 10;
    private static final int MAX_LVL = 100;

    private List<Planter> planters;
    private int level;


    public PlanterCategory() {
        planters = new ArrayList<Planter>();
        level = 1;
    }

    public void startWorking(){
        planters.forEach((planter)->planter.startWorking());
    }

    public void setLand(Land l){
        planters.forEach((planter)->planter.setLand(l));
    }

    public float getSalary(){
        float sumSalary=0;
        for(Planter p : planters){
            sumSalary += p.getSalary();
        }
        return sumSalary;
    }


    @Override
    public float estimatePrice() {
        return (float) (PRICE_MULT*Math.pow(level,2));
    }

    @Override
    public void upgrade() {
        if(level<MAX_LVL){
            Company.pay(estimatePrice());
            level++;
            //For each element of woodcutters, we set the new speed
            planters.forEach( (planter) -> planter.levelUp(1));
        }
    }

    @Override
    public void buy() {
        planters.add(new Planter(Integer.toString(planters.size()),level,1));
    }
}
