import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {
    private String name;

    List<Demand> demands;

    Client(String name){
        this.name = name;
        demands = new ArrayList<Demand>();
        demands.add(new Demand());
    }

    public String toString(){
        String str = name+"\n";
        Iterator<Demand> it = demands.iterator();
        while(it.hasNext()){
            str+=""+it.next().toString()+"\n";
            it.remove();
        }
        return str;
    }
}
