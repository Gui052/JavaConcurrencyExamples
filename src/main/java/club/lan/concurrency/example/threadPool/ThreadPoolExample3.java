package club.lan.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 创建一个单线程化的线程池，保证所有线程按照一定顺序（FIFO,UFO，优先级）执行
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31  16:20
 */
@Slf4j
public class ThreadPoolExample3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
