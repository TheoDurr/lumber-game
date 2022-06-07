import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Stock {
    private int maxCapacity;

    private List<Tree> content;

    public Stock(){
        maxCapacity = 20;
        content = new ArrayList<Tree>();
    }

    public boolean isFull(){
        return content.size() == maxCapacity;
    }

    public void add(Tree t){
        content.add(t);
    }

    public String toString(){
        String str = content.size()+"/"+maxCapacity+"\n";
        Iterator<Tree> it = content.iterator();
        while(it.hasNext()){
            str+=" -"+it.next().toString();
            it.remove();
        }
        return str;
    }
}
