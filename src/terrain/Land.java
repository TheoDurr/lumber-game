package terrain;

import wood.TreeState;

public class Land {
    static final int LAND_SIZE = 20;
    //We use an array because the number of emplacements in a land wont grow
    private Emplacement[] emplacements;

    private Stock stock;

    public Land(){
        emplacements = new Emplacement[LAND_SIZE+1];
        for(int i = 0; i<LAND_SIZE; i++){
            emplacements[i] = new Emplacement();
        }
        emplacements[LAND_SIZE] = new Emplacement(EmplacementType.REST);
        this.stock = new Stock();
    }
    
    public Stock getStock() {
        return stock;
    }

    private Emplacement getAvailableEmp(boolean forWoodcutter){
        Emplacement availableEmplacement = null;
        for (Emplacement emp : emplacements) {
            if (forWoodcutter ? conditionForWoodcutter(emp) : conditionForPlanter(emp)) {
                availableEmplacement = emp;
            }
        }
        return availableEmplacement;
    }

    private boolean conditionForWoodcutter(Emplacement emp){
        return !emp.isOccupied() && emp.getType() == EmplacementType.TREE && emp.hasTree() && emp.getTree().getState() == TreeState.MATURE;
    }

    private boolean conditionForPlanter(Emplacement emp){
        return !emp.isOccupied() && emp.getType()==EmplacementType.TREE && !emp.hasTree();
    }

    public synchronized Emplacement getEmplacementForWC(){
        Emplacement emp = getAvailableEmp(true);
        try{
            while(stock.isFull() || emp == null) {
                wait();
                emp = getAvailableEmp(true);
            }
        }catch(Exception e){e.printStackTrace();}
        emp.arrives();
        return emp;
    }

    public synchronized Emplacement getEmplacementForP(){
        Emplacement emp = getAvailableEmp(false);
        try{
            while(emp == null) {
                wait();
                emp = getAvailableEmp(false);
            }
        }catch(Exception e){e.printStackTrace();}
        emp.arrives();
        return emp;
    }

    public Emplacement getRestEmplacement(){
        return emplacements[LAND_SIZE];
    }

    public String toString(){
        StringBuilder str = new StringBuilder("Emplacements :\n");
        for(int i = 0; i<LAND_SIZE; i++){
            str.append(i).append(" : ").append(emplacements[i].toString()).append("\n");
        }
        str.append("terrain.Stock : ").append(stock.toString());
        return str.toString();
    }
}
