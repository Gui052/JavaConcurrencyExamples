package club.lan.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/29  14:19
 */
@Slf4j
public class SynchronizedExample2 {
    //如果子类调用test1的方法，是没有synchronized作用的，需要自己添加，因为这个不是属于方法声明的一部分。
    //修饰一个代码块
    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1-{}-{}", i, j);
            }
        }
    }
    //修饰一个方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2-{}-{}", i, j);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();

        ExecutorService executorService = Executors.newCachedThreadPool(); //声明一个线程池
        //调用两个线程池同时执行
        executorService.execute(()->{
            example1.test1(1);
        });
        executorService.execute(()->{
            example2.test1(2);
        });
    }
}
