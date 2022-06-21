package terrain;

import company.Company;
import employee.PurchaseUpgrade;
import employee.Woodcutter;

import java.util.ArrayList;
import java.util.List;

public class StockCategory implements PurchaseUpgrade {

    private static final int PRICE_MULT = 100;

    private List<Stock> stocks;

    private int level;

    public StockCategory(){
        stocks = new ArrayList<Stock>();
        level = 1;
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
        stocks.forEach( (stock) -> stock.levelUp(1));
    }

    @Override
    public void buy() {
        //TODO give it the same level as the other
        stocks.add(new Stock());
    }
}
