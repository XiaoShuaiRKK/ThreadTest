package tick.system;

/**
 * 门票总数
 */
public class TickDatabase {
    public static int numberOfTicks = 1000000;
    /**
     * 修改版本号
     */
    public static int version = 0;
    /**
     * 锁
     */
    public static final Object lock = new Object();
}
