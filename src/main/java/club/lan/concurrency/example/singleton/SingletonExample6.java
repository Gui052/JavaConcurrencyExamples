package club.lan.concurrency.example.singleton;

import club.lan.concurrency.annoations.ThreadSafe;

/** 饿汉模式
 * 考虑两个问题：构造方法没有过多处理。这个类一定会被使用，就不会导致资源浪费
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  11:37
 */
@ThreadSafe
public class SingletonExample6 {

    private SingletonExample6() { }

    //单例对象
    private static SingletonExample6 instance;

    //static会按代码编写顺序执行
    static {
        instance = new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }
}
