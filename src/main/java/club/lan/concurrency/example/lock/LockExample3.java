package club.lan.concurrency.example.lock;

import club.lan.concurrency.annoations.ThreadSafe;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/** ReentrantReadWriteLock  读写加锁
 * @author lan
 * @version 1.0.0
 * @since 2019/3/28  23:50
 */
@Slf4j
@ThreadSafe
public class LockExample3 {
    private final Map<String, Data> map = new TreeMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readlock = lock.readLock();
    private final Lock writelock = lock.writeLock();

    public Data get(String key) {
        readlock.lock();
        try {
            return map.get(key);
        }
        finally {
            readlock.unlock();
        }
    }

    public Data put(String key, Data value) {
        writelock.lock();
        try {
            return map.put(key, value);
        }finally {
            writelock.unlock();
        }
    }
    public Set<String> getAllKeys() {
        readlock.lock();
        try {
            return map.keySet();
        }finally {
            readlock.unlock();
        }
    }

    class Data {

    }
}
