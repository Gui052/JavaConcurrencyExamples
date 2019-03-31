package club.lan.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31  14:02
 */
@Slf4j
public class CyclicBarrierExample3 {
    private static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        log.info("callback is running");
    });//这样是，当线程达到计数器时候，执行里面的方法

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(()->{
                try {
                    rece(threadNum);
                } catch (Exception e) {
                    log.error("except", e);
                }
            });
        }
        exec.shutdown();
    }

    private static void rece(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await(); //加计数器
        log.info("{} is continue",threadNum);
    }
}
