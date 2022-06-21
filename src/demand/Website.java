package demand;

public class Website extends Terminal implements TerminalSingleton {
    /*
      This class is a Singleton. Only one instance of it exists
     */

    /**
     * Unique pre-initialized instance
     **/
    private static Website INSTANCE = null;

    /**
     * Private constructor
     **/
    private Website() {
    }

    /**
     * Method called to retrieve the instance of this Singleton
     *
     * @return The unique instance
     */
    public static Website getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Website();
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
