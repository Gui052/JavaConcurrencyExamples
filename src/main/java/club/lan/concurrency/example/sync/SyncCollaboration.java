package club.lan.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程间协作
 */
public class SyncCollaboration {
    public static void main(String[] args) {
        SyncCollaboration syncCollaboration = new SyncCollaboration();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(syncCollaboration::after);
        executorService.submit(syncCollaboration::before);
        executorService.shutdown();
    }

    public synchronized void before() {
        System.out.println("before");
        //唤醒所有线程
        notifyAll();
        //随机唤醒一个线程
        //notify();
    }

    public synchronized void after() {
        try {
            System.out.println("wait");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

}
