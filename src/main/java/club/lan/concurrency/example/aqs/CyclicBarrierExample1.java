package club.lan.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31  14:02
 */
@Slf4j
public class CyclicBarrierExample1 {
    private static CyclicBarrier barrier = new CyclicBarrier(5);//设定计数器为5

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
