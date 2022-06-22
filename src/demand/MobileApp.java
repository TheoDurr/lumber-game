package demand;

public class MobileApp extends Terminal implements TerminalSingleton {
    /*
     * This class is a Singleton. Only one instance of it exists
     */

    /**
     * Unique pre-initialized instance
     **/

    private static MobileApp INSTANCE = null;

    /**
     * Private constructor
     **/
    private MobileApp() {
        super();
    }

    /**
     * Access point for the unique singleton instance
     **/
    public static MobileApp getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MobileApp();
        }

        return INSTANCE;
    }

    @Override
    public void init(float creationCost, float maintenanceCost, int maxDemands, int refreshDelay) {
        super.init(creationCost, maintenanceCost, maxDemands, refreshDelay);
    }

    @Override
    public float estimatePrice() {
        //FIXME: return real value
        return 0;
    }

    @Override
    public void upgrade() {
        //TODO: implement me
    }
}
