package JUC_Demo;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.put("a");
        linkedBlockingQueue.put("b");
        String take = linkedBlockingQueue.take();
        System.out.println(take);
    }

}
