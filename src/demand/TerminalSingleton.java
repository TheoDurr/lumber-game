package demand;

public interface TerminalSingleton {
    static Terminal getInstance() {
        return null;
    }

    void init(float creationCost, float maintenanceCost, int maxDemands, int refreshDelay);
}
