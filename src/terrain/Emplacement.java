package terrain;

import wood.Tree;
import wood.TreeState;

import java.util.Objects;

public class Emplacement {
    private boolean isOccupied;

    private Tree tree;

    private EmplacementType type;

    public Emplacement(){
        isOccupied = false;
        tree = new Tree(TreeState.MATURE);
        type = EmplacementType.TREE;
    }
    
    public Emplacement(EmplacementType t){
        isOccupied = false;
        tree = null;
        type = t;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public boolean hasTree(){
        return !Objects.isNull(tree);
    }

    public Tree getTree(){
        return tree;
    }

    public EmplacementType getType(){
        return type;
    }

    //Method to call when a worker arrives in this emplacement
    public void arrives(){
        isOccupied = true;
    }

    //Method to call when a worker leaves this emplacement
    public void leaves(){
        isOccupied = false;
    }

    //Method to call when a worker plant a tree in this emplacement
    public void plantTree(Tree t){
        tree = t;
    }

    //Method to call when a worker remove a tree (to put it in the stock for example)
    public void removeTree(){
        tree = null;
    }


    public String toString(){
        String str="";
        if(type == EmplacementType.TREE){
            if(hasTree()) str+="Contains " + tree.getState();
    
            else str+="Do not contains a tree";
    
            if(isOccupied) str += " and is occupied";
    
            else str+= " and isn't occupied";
        }

        return str;
    }

}
