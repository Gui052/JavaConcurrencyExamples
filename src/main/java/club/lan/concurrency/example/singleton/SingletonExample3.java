package club.lan.concurrency.example.singleton;

import club.lan.concurrency.annoations.NotRecommend;
import club.lan.concurrency.annoations.ThreadSafe;

/** 懒汉模式--线程安全
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  11:37
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3() { }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态的工厂方法。性能开销大
    public static synchronized SingletonExample3 getInstance() {
        if (instance==null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
