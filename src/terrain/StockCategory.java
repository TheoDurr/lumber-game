package terrain;

import company.Company;
import employee.PurchaseUpgrade;
import wood.Wood;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockCategory implements PurchaseUpgrade {

    private static final int PRICE_MULT = 100;

    private final List<Stock> stocks;

    private int level;

    public StockCategory(Stock firstStock) {
        stocks = new ArrayList<Stock>();
        stocks.add(firstStock);
        level = 1;
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }

    public Stock getStock(int index) {
        return stocks.get(index);
    }

    @Override
    public float estimatePrice() {
        return (float) (PRICE_MULT * Math.pow(level, 2));
    }

    @Override
    public void upgrade() {
        Company.pay(estimatePrice());
        level++;
        //For each element of woodcutters, we set the new speed
        stocks.forEach((stock) -> stock.levelUp(1));
    }

    @Override
    public void buy() {
        stocks.add(new Stock(this.level));
    }

    public int getMaxCapacity() {
        int maxCapacityTot = 0;
        for (int counter = 0; counter < stocks.size(); counter++) {
            maxCapacityTot += stocks.get(counter).getMaxCapacity();
        }
        return maxCapacityTot;
    }

    public int getCurrentCapacity() {
        int maxCurrentCapTot = 0;
        for (int counter = 0; counter < stocks.size(); counter++) {
            maxCurrentCapTot += stocks.get(counter).getCurrentCapacity();
        }
        return maxCurrentCapTot;
    }


    public int getLevel() {
        return level;
    }

    public Stock getStockWithSmallestContent() {
        Iterator<Stock> it = stocks.iterator();
        Stock stockToReturn = stocks.get(0);

        while (it.hasNext()) {
            Stock currentStock = it.next();
            if (currentStock.getCurrentCapacity() < stockToReturn.getCurrentCapacity()) {
                stockToReturn = currentStock;
            }
        }

        return stockToReturn;
    }

    public Stock getStockWithBiggestContent() {
        Iterator<Stock> it = stocks.iterator();
        Stock stockToReturn = stocks.get(0);

        while (it.hasNext()) {
            Stock currentStock = it.next();
            if (currentStock.getCurrentCapacity() > stockToReturn.getCurrentCapacity()) {
                stockToReturn = currentStock;
            }
        }

        return stockToReturn;

    }

    // Remove wood from the stocks with the biggest amount of wood
    public List<Wood> removeWood(int quantity) {
        List<Wood> returnList = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            returnList.addAll(this.getStockWithBiggestContent().removeWood(1));
        }
        return returnList;
    }
}

