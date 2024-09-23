import tick.system.OptimisticTickerMachine;
import tick.system.PessimisticTicketMachine;
import tick.system.TickDatabase;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        pessimisticLock();
        optimisticLock();
    }

    public static void optimisticLock() throws InterruptedException {
        long start = System.currentTimeMillis();
        OptimisticTickerMachine t1 = new OptimisticTickerMachine("Optimistic-T1");
        OptimisticTickerMachine t2 = new OptimisticTickerMachine("Optimistic-T2");
        OptimisticTickerMachine t3 = new OptimisticTickerMachine("Optimistic-T3");
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(3000);
        System.out.println("Spend Time : " + (System.currentTimeMillis() - start - 3000) + " ms");
        System.out.println("t1 : " + t1.getSellTick());
        System.out.println("t2 : " + t2.getSellTick());
        System.out.println("t3 : " + t3.getSellTick());
        System.out.println("All : " + (t1.getSellTick() + t2.getSellTick() + t3.getSellTick()));
        System.out.println(TickDatabase.numberOfTicks);
    }

    public static void pessimisticLock() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        PessimisticTicketMachine t1 = new PessimisticTicketMachine("Pessimistic-T1");
        PessimisticTicketMachine t2 = new PessimisticTicketMachine("Pessimistic-T2");
        PessimisticTicketMachine t3 = new PessimisticTicketMachine("Pessimistic-T3");
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(3000);
        System.out.println("Spend Time : " + (System.currentTimeMillis() - startTime - 3000) + " ms");
        System.out.println("t1 : " + t1.getSellTick());
        System.out.println("t2 : " + t2.getSellTick());
        System.out.println("t3 : " + t3.getSellTick());
        System.out.println("All : " + (t1.getSellTick() + t2.getSellTick() + t3.getSellTick()));
        System.out.println(TickDatabase.numberOfTicks);
    }
}