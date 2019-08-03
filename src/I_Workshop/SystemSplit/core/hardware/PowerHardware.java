package I_Workshop.SystemSplit.core.hardware;

public class PowerHardware extends Hardware {

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.POWER, maximumCapacity, maximumMemory);
    }

    @Override
    public int getMaximumCapacity() {
        // decreases 75% of its given capacity
        return super.getMaximumCapacity() - ((super.getMaximumCapacity() * 3) / 4);
    }

    @Override
    public int getMaximumMemory() {
        return super.getMaximumMemory();
    }
}
