package employee;

import terrain.Stock;
import terrain.StockCategory;

public interface MachinePurchaseUpgrade {
    float estimatePrice();

    void upgrade();

    void buy(StockCategory inputStock, StockCategory outputStock);
}
