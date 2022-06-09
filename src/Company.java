public class Company {

  private String name;

  private String CEO;

  private String pays;

  private double cashFlow;

  private int nbPlank;

  private void pay(float amount) {
    cashFlow-=amount;
  }

  public void cashIn(float amount) {
    cashFlow+=amount;
  }

  public void payInPlanks(int amountInPlank) {
    nbPlank -=amountInPlank;
  }


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getCEO() {
    return CEO;
  }
  public void setCEO(String CEO) {
    this.CEO = CEO;
  }

  public String getPays() {
    return pays;
  }
  public void setPays(String pays) {
    this.pays = pays;
  }

  public double getCashFlow() {
    return cashFlow;
  }
  public void setCashFlow(double cashFlow) {
    this.cashFlow = cashFlow;
  }

  public int getNbPlank() {
    return nbPlank;
  }
  public void setNbPlank(int nbPlank) {
    this.nbPlank = nbPlank;
  }



}