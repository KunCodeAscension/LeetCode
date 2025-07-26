package JUC_Demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map<Integer,Integer> map = Collections.synchronizedMap(new HashMap<>());
        map.put(1,1);
    }

}
