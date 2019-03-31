package club.lan.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31  14:02
 */
@Slf4j
public class SemaphoreExample2 {
    private static int threadCount = 200;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3); //当前有多少个许可

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(()->{
                try {

                    semaphore.acquire(3); //获取许可。可以选择参数，一次性拿走多少个许可
                    test(threadNum);
                    semaphore.release(3); //释放许可

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
