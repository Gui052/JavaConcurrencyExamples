package club.lan.concurrency.example.deal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按顺序打印1到100
 */
public class PrintNumber {

    Lock lock = new ReentrantLock();

    private Integer count = 1;
    public static void main(String[] args) throws InterruptedException {
        PrintNumber printNumber = new PrintNumber();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(printNumber::print);
        }
        for (int i = 0; i < 100; i++) {
            executor.execute(printNumber::print2);
        }
        System.out.println("down");
        //等待任务结束之后关闭线程池
        executor.shutdown();
    }

    public synchronized void print() {
        if (count > 30) {
            return;
        }
        System.out.println(count);
        count++;
    }

    public void print2() {
        try {
            Thread.sleep(1000);
            lock.lock();
            if (count < 60) {
                count++;
                System.out.println(count);
            }
        } catch (Exception e) {
            //
        }finally {
            lock.unlock();
        }
    }
}
