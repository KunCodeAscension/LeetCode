package JUC_Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDeno {
    public static void main(String[] args) throws InterruptedException {
        int totalDetail = 100000;
        int threadCount = 20;
        int batchSize = totalDetail / threadCount;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < threadCount; i++) {
            int start = i * batchSize;
            int end = (i == threadCount - 1) ? totalDetail : (start + batchSize);
            executor.execute(() -> {
                try {
                    for (int j = start; j < end; j++) {
                        list.add(j);
                    }
                    System.out.println(Thread.currentThread().getName() + "over");
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executor.shutdown();
        System.out.println("所有线程完毕" + list.size());
    }
}
