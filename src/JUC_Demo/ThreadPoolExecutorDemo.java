package JUC_Demo;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    /**
     * 固定大小的线程池
     * 原理：核心线程数和最大线程数的大小一致 普通线程空闲超时释放的时间为0 阻塞队列为 LinkedBlockingQueue
     * 适用于 IO 密集型任务、数据库连接池等。
     */
    public void setFixedThreadPool() {
        Executor FixedThreadPool1 = Executors.newFixedThreadPool(10);
        Executor FixedThreadPool2 = new ThreadPoolExecutor(10,
                10,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
    }

    /**
     * 缓存线程池，核心线程为0，最大线程数为Integet.MAX_VALUE，普通线程空闲超时释放时间为60秒 阻塞队列为SynchronousQueue
     * SynchronousQueue 并不是一个真正意义上的队列，也叫做配对队列，它的内部容量为0，发送或者消费线程会阻塞，只有有一对消费和发送线程匹配上，才同时退出。
     * 适用于短时间内波动量大的场景，如短时间内有大量的文件处理任务或网络请求
     */
    public void setCachedThreadPool() {
        Executor CachedThreadPool1 = Executors.newCachedThreadPool();
        Executor CachedThreadPool2 = new ThreadPoolExecutor(0,
                Integer.MAX_VALUE,
                60,
                TimeUnit.SECONDS,
                new SynchronousQueue<>());
    }

    /**
     * 定时任务线程池，用于执行定时任务，使用静态内部阻塞队列类 DelayedWorkQueue实现，核心线程自己传入参数，最大线程数为Integet.MAX_VALUE
     * 适用于一些发邮件，发短信等业务场景
     */
    public void setScheduledThreadPool(){
        ScheduledThreadPoolExecutor ScheduledThreadPool1 = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        ScheduledThreadPoolExecutor ScheduledThreadPool2 = new ScheduledThreadPoolExecutor(10);
        // 执行定时任务时，
        // schedule() 方法可以将任务延迟一定时间后执行一次；
        // scheduleAtFixedRate() 方法可以将任务延迟一定时间后以固定频率执行；
        // scheduleWithFixedDelay() 方法可以将任务延迟一定时间后以固定延迟执行。
        ScheduledThreadPool2.schedule(() -> {
            System.out.println("定时任务执行");
        },3,TimeUnit.SECONDS);
    }

    /**
     * 单线程线程池，只有一个核心线程，最大线程数为0，所以这个线程池有且仅有一个核心线程
     * 适用于需要按顺序执行任务的场景。例如，日志记录、文件处理等
     */
    public void setSingleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
    }

    public void ThreadExecutorException(){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        // 异常处理方式一：try-cache捕获
        executor.execute(() -> {
            try {
                System.out.println("任务开始");
                int result = 1 / 0; // 除零异常
            } catch (Exception e) {
                System.err.println("捕获异常：" + e.getMessage());
            }
        });
        // 异常处理方式二：Future获取异常
        Future<Object> future = executor.submit(() -> {
            System.out.println("任务开始");
            int result = 1 / 0; // 除零异常
            return result;
        });
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("捕获异常：" + e.getMessage());
        }
        // 异常处理方式三：自定义 ThreadPoolExecutor 重写 afterExecute 方法。
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(
                10,
                10,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()){
            public void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t != null) {
                    System.out.println("捕获异常" + t.getMessage());
                }
            }
        };
        // 异常处理方式四：使用 UncaughtExceptionHandler 捕获异常。
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(
                10,
                10,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                            public void uncaughtException(Thread t, Throwable e) {
                                System.out.println("捕获异常" + e.getMessage());
                            }
                        });
                        return thread;
                    }
        });
        // 线程池参数动态变化 还可以利用 Nacos 配置中心，或者实现自定义的线程池，监听参数变化去动态调整参数
        threadPoolExecutor2.setCorePoolSize(12);
        threadPoolExecutor2.setMaximumPoolSize(12);
    }

}
