package company;

import demand.Customer;
import terrain.Stock;
import terrain.StockCategory;

public final class Company {

    private static String name;

    private static String CEO;

    private static String pays;

    private static double cashFlow;

    private static int nbPlank;

    private static Customer[] customerBook;

    //TODO: @AlexisB edit this to stock category

    private static StockCategory finalStocks;

    public static void init(String name, String CEO, String pays, Customer[] customerBook, float baseCashFlow, Stock initialFinalStock) {
        Company.name = name;
        Company.CEO = CEO;
        Company.pays = pays;
        Company.customerBook = customerBook;
        Company.cashFlow = baseCashFlow;
        finalStocks = new StockCategory(initialFinalStock);
    }

    public static boolean pay(float amount) {
        if (cashFlow < amount) {
            return false;
        } else {
            cashFlow -= amount;
            System.out.println("COUCUOUOCUOCUOCUOCUOUOCUO");
            return true;
        }
    }

    public static StockCategory getFinalStockCategory() {
        return Company.finalStocks;
    }

    public static void cashIn(float amount) {
        cashFlow += amount;
    }

    public static void payInPlanks(int amountInPlank) {
        finalStocks.sendWoodToCommand(amountInPlank);
    }

    public static String getName() {
        return name;
    }

    public String getCEO() {
        return CEO;
    }

    public String getPays() {
        return pays;
    }

    public static double getCashFlow() {
        return cashFlow;
    }

    public static int getNbPlank() {
        return nbPlank;
    }

    public static Customer[] getCustomerBook() {
        return customerBook;
    }
}