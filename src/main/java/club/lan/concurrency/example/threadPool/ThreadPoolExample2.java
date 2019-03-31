package club.lan.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 建一个定长线程池，可控制线程最大并发量，超出的线程会在队列中等待
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31  16:20
 */
@Slf4j
public class ThreadPoolExample2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task{}",index);
                }
            });
        }
        executorService.shutdown();
    }
}
