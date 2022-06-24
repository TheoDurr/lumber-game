package vehicle;

public class Forklift extends Vehicle{

    public Forklift(){
        super();
        capacity = 3;
    }

    public void levelUp(int lvl){
        level++;
        capacity += 1;
    }
    @Override
    public int getLevel() {
        return super.getLevel();
    }
}