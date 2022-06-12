package demand;

public class Website extends Terminal {
    /*
      This class is a Singleton. Only one instance of it exists
     */

    /**
     * Unique pre-initialized instance
     **/
    private static Website INSTANCE = new Website();

    /**
     * Private constructor
     **/
    private Website() {
    }

    /**
     * Access point for the unique singleton instance
     **/
    public static Website getInstance() {
        return INSTANCE;
    }
}
