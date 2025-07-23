public class ThreadLocalDemo {
    // 定义两个不同的ThreadLocal对象
    private static final ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);
    private static final ThreadLocal<String> name = ThreadLocal.withInitial(() -> "default");

    public static void main(String[] args) throws InterruptedException {
        name.set("default");
        counter.set(counter.get() + 1);
        System.out.println(counter.get());
        System.out.println(Thread.currentThread().getName());
        counter.remove();
        name.remove();
    }
}