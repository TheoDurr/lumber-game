public class Tree {
    private TreeState state;

    public Tree(){
        state=TreeState.SEED;
    }

    public Tree(TreeState st){
        state=st;
    }

    public TreeState getState() {
        return state;
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
            case TRUNK :
                state = TreeState.PLANK;
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
}
