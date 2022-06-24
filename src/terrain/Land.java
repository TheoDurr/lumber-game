package terrain;

import terrain.Stock;
import wood.TreeState;

public class Land {
    static final int LAND_SIZE = 20;
    //We use an array because the number of emplacements in a land wont grow
    private Emplacement[] emplacements;

    private int nbOfWoodcutter;
    private int nbOfPlanter;

    private Stock stock;

    public Land(){
        emplacements = new Emplacement[LAND_SIZE+1];
        for(int i = 0; i<LAND_SIZE; i++){
            emplacements[i] = new Emplacement();
        }
        emplacements[LAND_SIZE] = new Emplacement(EmplacementType.REST);
        this.stock = new Stock();
        nbOfWoodcutter=0;
        nbOfPlanter=0;
    }
    
    public Stock getStock() {
        return stock;
    }

    public synchronized Emplacement getEmplacementForWC(){
        for(Emplacement emp : emplacements){
            if(!emp.isOccupied() && emp.getType()==EmplacementType.TREE && emp.hasTree() && emp.getTree().getState() == TreeState.MATURE){
                emp.arrives();
                return emp;
            }
        }
        return getRestEmplacement();
    }

    public synchronized Emplacement getEmplacementForP(){
        for(Emplacement emp : emplacements){
            if(!emp.isOccupied() && emp.getType()==EmplacementType.TREE && !emp.hasTree()){
                emp.arrives();
                return emp;
            }
        }
        return getRestEmplacement();
    }

    public Emplacement getRestEmplacement(){
        return emplacements[LAND_SIZE];
    }

    public void newWoodcutter(){
        nbOfWoodcutter++;
    }

    public void newPlanter(){
        nbOfPlanter++;
    }

    public int getNbOfWoodcutter() {
        return nbOfWoodcutter;
    }

    public int getNbOfPlanter() {
        return nbOfPlanter;
    }

    public String toString(){
        String str ="Emplacements :\n";
        for(int i = 0; i<LAND_SIZE; i++){
            str+=i+ " : " + emplacements[i].toString() +"\n";
        }

        str +="terrain.Stock : "+stock.toString();

        return str;
    }
    
}
