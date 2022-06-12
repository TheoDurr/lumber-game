package demand;

public class MobileApp extends Terminal {
    /*
     * This class is a Singleton. Only one instance of it exists
     */

    /**
     * Unique pre-initialized instance
     **/

    private static MobileApp INSTANCE = new MobileApp();

    /**
     * Private constructor
     **/
    private MobileApp() {
    }

    /**
     * Access point for the unique singleton instance
     **/
    public static MobileApp getInstance() {
        return INSTANCE;
    }
}
