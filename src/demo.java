import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class demo {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.get(1);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,2);
        concurrentHashMap.get(1);
        Hashtable<Integer,Integer> map2 = new Hashtable<>();
        map2.put(1,2);
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("1");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("1");
    }

}
