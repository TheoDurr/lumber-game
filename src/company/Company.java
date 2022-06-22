package company;

import demand.Customer;
import terrain.Stock;

public final class Company {

    private static String name;

    private static String CEO;

    private static String pays;

    private static double cashFlow;

    private static int nbPlank;

    private static Customer[] customerBook;

    //TODO: @AlexisB edit this to stock category
    private static Stock finalStock = new Stock();

    public static void init(String name, String CEO, String pays, Customer[] customerBook, float baseCashFlow) {
        Company.name = name;
        Company.CEO = CEO;
        Company.pays = pays;
        Company.customerBook = customerBook;
        Company.cashFlow = baseCashFlow;
    }

    public static boolean pay(float amount) {
        if (cashFlow < amount) {
            return false;
        } else {
            cashFlow -= amount;
            return true;
        }
    }

    public static Stock getFinalStock() {
        return Company.finalStock;
    }

    public void cashIn(float amount) {
        cashFlow += amount;
    }

    public void payInPlanks(int amountInPlank) {
        nbPlank -= amountInPlank;
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

    public int getNbPlank() {
        return nbPlank;
    }

    public static Customer[] getCustomerBook() {
        return customerBook;
    }
}