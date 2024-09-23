package tick.system;

/**
 * 悲观锁实现
 */
public class PessimisticTicketMachine extends Thread {
    int sellTick = 0;

    public PessimisticTicketMachine(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            synchronized (TickDatabase.lock){
                if(TickDatabase.numberOfTicks <= 0)
                    break;
                TickDatabase.numberOfTicks--;
                sellTick++;
                System.out.println(this.getName() + " : " + TickDatabase.numberOfTicks);
            }
        }
    }

    public int getSellTick() {
        return sellTick;
    }
}
