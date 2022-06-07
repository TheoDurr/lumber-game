import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Stock {
    private int maxCapacity;

    private List<Tree> content;

    public Stock() {
        this.setMaxCapacity(20);
        content = new ArrayList<Tree>();
    }

    public Stock(int maxCapacity) {
        this.setMaxCapacity(maxCapacity);
        content = new ArrayList<Tree>();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Tree> getContent() {
        return content;
    }

    public void setContent(List<Tree> content) {
        this.content = content;
    }

    public int getAvailableSpace(){
        return this.getMaxCapacity() - this.content.size();
    }

    public boolean isFull() {
        return this.getAvailableSpace() == 0;
    }

    public void add(Tree t) {
        content.add(t);
    }

    public void add(Tree[] trees) {
        if (!this.isFull()) {
            content.addAll(Arrays.asList(trees));
        }
    }

    public void remove(Tree t) {
        content.remove(t);
    }

    public void remove(Tree[] trees) {
        content.removeAll(Arrays.asList(trees));
    }

    public String toString() {
        String str = content.size() + "/" + maxCapacity + "\n";
        Iterator<Tree> it = content.iterator();
        while (it.hasNext()) {
            str += " -" + it.next().toString();
            it.remove();
        }
        return str;
    }
}
