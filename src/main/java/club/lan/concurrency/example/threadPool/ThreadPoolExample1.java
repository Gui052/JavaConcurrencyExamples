package club.lan.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**创建可缓存线程池 ，如果长度超过所需，可以自动回收空闲线程，如果不够则创建新的。
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31
 */
@Slf4j
public class ThreadPoolExample1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

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
