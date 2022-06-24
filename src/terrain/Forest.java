package terrain;

import company.Company;

import java.util.ArrayList;
import java.util.Iterator;

public class Forest extends Terrain {

  public final int PRICE_TO_EXTEND = 100000;

  private ArrayList<Land> lands;

  private StockCategory stocks;


  public Forest(Land firstLand){
    lands = new ArrayList<>(1);
    stocks = new StockCategory(firstLand.getStock());
    lands.add(firstLand);
    System.out.println("1Forest, lands.size" + lands.size());

  }

  public Land getLandFewestWC(){

    Iterator<Land> it= lands.iterator();
    Land landToReturn = lands.get(0);

    while(it.hasNext()){
      Land currentLand = it.next();
      if(currentLand.getNbOfWoodcutter()<landToReturn.getNbOfWoodcutter()){
        landToReturn=currentLand;
      };
    }

    return landToReturn;
  }

  public Land getLandFewestP(){
    Iterator<Land> it= lands.iterator();
    Land landToReturn = lands.get(0);

    while(it.hasNext()){
      Land currentLand = it.next();
      if(currentLand.getNbOfPlanter()<landToReturn.getNbOfPlanter()){
        landToReturn=currentLand;
      };
      it.remove();
    }
    return landToReturn;
  }

  public float getPrice(){
    return PRICE_TO_EXTEND*lands.size();
  }

  public void expandForest() {
    if(Company.pay(getPrice())){
      lands.add(new Land());
      stocks.addStock(lands.get(lands.size()).getStock());
    }

  }

  public ArrayList<Land> getLands() {
    return lands;
  }

  public Stock getStock(int index) {
    return stocks.getStock(index);
  }

  public StockCategory getStockCategory(){
    return stocks;
  }
}