package employee;

import terrain.Stock;

public interface MachinePurchaseUpgrade extends PurchaseUpgrade{

    public void buy(Stock inputStock, Stock outputStock);
}
