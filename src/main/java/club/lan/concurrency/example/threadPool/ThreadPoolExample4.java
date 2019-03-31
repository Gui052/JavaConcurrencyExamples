package club.lan.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** newScheduledThreadPool  创建一个定长线程池，支持定时以及周期性的执行任务
 * @author lan
 * @version 1.0.0
 * @since 2019/3/31  16:20
 */
@Slf4j
public class ThreadPoolExample4 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("run");
            }
        }, 3, TimeUnit.SECONDS); //延迟三秒执行

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("run");
            }
        }, 1, 3, TimeUnit.SECONDS); //延迟一秒，每3秒执行
        //和Timer很像
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("timer run");
            }
        }, new Date(), 5 * 1000);

        executorService.shutdown();
    }
}
