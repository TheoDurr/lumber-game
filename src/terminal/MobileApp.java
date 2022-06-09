package terminal;

public class MobileApp extends Terminal {
    /** Private constructor **/
    private MobileApp(){}

    /** Unique pre-initialized instance **/
    private static MobileApp INSTANCE = new MobileApp();

    /** Access point for the unique singleton instance **/
    public static MobileApp getInstance(){
        return INSTANCE;
    }
}
