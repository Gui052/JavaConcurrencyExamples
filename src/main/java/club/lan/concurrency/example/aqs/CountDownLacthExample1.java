package club.lan.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31  14:02
 */
@Slf4j
public class CountDownLacthExample1 {
    private static int threadCount = 200;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.info("{}", e);
                }finally {
                    countDownLatch.countDown();//每一次完成之后都要减一
                }
            });
        }
        countDownLatch.await(); //调用await，要等待所有之前的线程完成后完成
        log.info("finish");
        exec.shutdown();//关闭线程池
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", threadNum);
        Thread.sleep(100);

    }
}
