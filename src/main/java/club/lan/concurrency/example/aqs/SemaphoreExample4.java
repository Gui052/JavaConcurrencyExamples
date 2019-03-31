package club.lan.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31  14:02
 */
@Slf4j
public class SemaphoreExample4 {
    private static int threadCount = 200;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3); //当前有多少个许可

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try {
                    if (semaphore.tryAcquire(5000,TimeUnit.MILLISECONDS)) {  //尝试获取许可，如果获取不到就等待特定时间
                        test(threadNum);
                        semaphore.release(); //释放许可
                    }
                } catch (InterruptedException e) {
                    log.info("{}", e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);

    }
}
