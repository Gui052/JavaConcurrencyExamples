package club.lan.concurrency.example.singleton;

import club.lan.concurrency.annoations.NotThreadSafe;
import club.lan.concurrency.annoations.ThreadSafe;

/** 饿汉模式--静态域写法
 * 考虑两个问题：构造方法没有过多处理。这个类一定会被使用，就不会导致资源浪费
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  11:37
 */
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2() { }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
