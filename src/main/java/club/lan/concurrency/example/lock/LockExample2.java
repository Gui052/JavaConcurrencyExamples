package club.lan.concurrency.example.lock;

import club.lan.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 一共5000个线程，每一时刻只能同时200个线程执行
 * @author lan
 * @version 1.0.0
 * @since 2019/3/28  23:50
 */
@Slf4j
@ThreadSafe
public class LockExample2 {
    //请求总数
    public static int clientTotal = 5000;

    //同时并发线程数
    public static int threadTotal = 200;

    private static int count = 0;

    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception:" + e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        lock.lock();
        try {
            count++;
        }finally {
            lock.unlock();
        }
    }
}
