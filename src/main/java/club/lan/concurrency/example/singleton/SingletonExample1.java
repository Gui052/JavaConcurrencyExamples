package club.lan.concurrency.example.singleton;

import club.lan.concurrency.annoations.NotThreadSafe;

/** 懒汉模式
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  11:37
 */
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1() { }

    //单例对象
    private static SingletonExample1 instance = null;

    //静态的工厂方法
    public static SingletonExample1 getInstance() {
        //线程不安全的
        if (instance==null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
