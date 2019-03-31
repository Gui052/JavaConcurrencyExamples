package club.lan.concurrency.example.atomic;

import club.lan.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/28  23:50
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    //原子性的去更新一个类的一个实例的某一个字段，字段必须用volatile修饰并且没有static修饰
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");
    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update count:{}", example5.getCount());
        }
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update count:{}", example5.getCount());
        } else {
            log.info("update failed count:{}", example5.getCount());
        }
    }

}
