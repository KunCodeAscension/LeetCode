import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class demo {

    public static void main(String[] args) {
        System.out.println(find());
    }

    public static Integer find(){
        try{
            return 1;
        }catch(Exception e){
            return 0;
        }finally {
            System.out.println(2113);
        }
    };


}
