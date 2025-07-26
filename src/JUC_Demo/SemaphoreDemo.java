package JUC_Demo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private static final int THREAD_COUNT = 5;
    private static final Semaphore semaphore = new Semaphore(2); // 最多允许 2 个线程访问

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("获取到访问许可" + finalI);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("释放访问许可" + finalI);
                    semaphore.release(); // 释放许可
                }
            }).start();
        }
    }

}
