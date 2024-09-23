package tick.system;

/**
 * 乐观锁
 */
public class OptimisticTickerMachine extends Thread {
    int sellTick = 0;

    public OptimisticTickerMachine(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            int currentTicks;
            int currentVersion;
            synchronized (TickDatabase.class){
                currentTicks = TickDatabase.numberOfTicks;
                currentVersion = TickDatabase.version;
            }

            if(currentTicks <= 0)
                break;
            synchronized (TickDatabase.class){
                if(currentVersion == TickDatabase.version && currentTicks == TickDatabase.numberOfTicks){
                    TickDatabase.numberOfTicks--;
                    TickDatabase.version++;
                    sellTick++;
                    System.out.println(this.getName() + " : " + TickDatabase.numberOfTicks);
                }
            }
        }
    }

    public int getSellTick() {
        return sellTick;
    }
}
