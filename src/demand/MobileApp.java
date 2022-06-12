package demand;

public class MobileApp extends Terminal {
    /*
     * This class is a Singleton. Only one instance of it exists
     */

    /** Private constructor **/
    private MobileApp(){}

    /** Unique pre-initialized instance **/

    private static MobileApp INSTANCE = new MobileApp();

    /** Access point for the unique singleton instance **/
    public static MobileApp getInstance(){
        return INSTANCE;
    }
}
