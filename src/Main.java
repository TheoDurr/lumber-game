public class Main {
    public static void main(String[] args) {
        Woodcutter w = new Woodcutter("Creput", 2, 2);
        Woodcutter w2 = new Woodcutter("Creut", 1, 2);
        Land l = new Land();

        w.setLand(l);
        w2.setLand(l);
        
        //Thread safe
        w.startWorking();

        //Since there are shared objects between these threads we need to be cautious 
        //TO_CHANGE
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w2.startWorking();



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(l.toString());
        
    }
}
