package JUC_Demo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

}

class DataContainer{
    private volatile int data;
    private final ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock r = rw.readLock();
    ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public DataContainer(int data){
        this.data = data;
    }

    public int getData(){
        r.lock();
        try{
            return data;
        }finally{
            r.unlock();
        }
    }

    public void setData(int data){
        w.lock();
        try {
            this.data = data;
        }finally{
            w.unlock();
        }
    }

    public void add(int data){
        w.lock();
        try {
            this.data += data;
        }finally{
            w.unlock();
        }
    }
}
