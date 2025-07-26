package JUC_Demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static final int THREAD_COUNT = 6;
    private static final CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println("到达屏障入口:" + finalI);
                    barrier.await();
                    System.out.println("到达屏障出口:" + finalI);
                } catch (BrokenBarrierException | InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {

                }
            }).start();
        }
    }

}
