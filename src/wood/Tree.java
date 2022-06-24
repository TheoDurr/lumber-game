package wood;

import terrain.Land;

import static java.lang.Thread.sleep;

public class Tree extends Wood{
    private static final int GROWING_TIME = 25000;

    private TreeState state;

    public Tree(){
        state= TreeState.SEED;
    }

    public Tree(TreeState st){
        state=st;
    }

    public TreeState getState() {
        return state;
    }

    public void setState(TreeState st) {
        state = st;
    }

    public void nextState(){
        switch(state) {
            case SEED :
                state = TreeState.SPROUT;
                break;
            case SPROUT :
                state = TreeState.MATURE;
                break;
            case MATURE :
                state = TreeState.TRUNK;
                break;
            default :
                state = TreeState.SEED;
                break;
        }
    }

    public String toString(){
        String str =state+"\n";
        return str;
    }

    public void hasBeenPlanted(Land land){
        state = TreeState.SPROUT;
        new Thread(() -> {
            try {
                sleep(GROWING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            state = TreeState.MATURE;
            synchronized (land){
                land.notifyAll();
            }
        }).start();
    }
}
