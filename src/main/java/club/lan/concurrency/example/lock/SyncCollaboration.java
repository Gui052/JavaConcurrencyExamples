package club.lan.concurrency.example.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间的协作
 */
public class SyncCollaboration {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        SyncCollaboration syncCollaboration = new SyncCollaboration();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(syncCollaboration::after);
        executorService.submit(syncCollaboration::before);
        executorService.shutdown();
    }

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            System.out.println("wait");
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
