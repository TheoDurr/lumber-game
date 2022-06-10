public class Main {
    public static void main(String[] args) {

        WoodcutterCategory wcc = new WoodcutterCategory();
        wcc.buy();
        wcc.buy();
        wcc.buy();
        wcc.buy();
        wcc.buy();
        wcc.buy();

        System.out.println(wcc.getSalary());

        Land l = new Land();
        wcc.setLand(l);
        wcc.startWorking();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wcc.upgrade();

        PlanterCategory pc = new PlanterCategory();
        pc.buy();
        pc.buy();
        pc.setLand(l);
        pc.startWorking();
    }
}
