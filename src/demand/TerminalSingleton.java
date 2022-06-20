package demand;

public interface TerminalSingleton {
    static Website getInstance() {
        return null;
    }

    void init(float creationCost, float maintenanceCost, int maxDemands, int refreshDelay);
}
