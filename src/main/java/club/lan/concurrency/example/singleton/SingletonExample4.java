package club.lan.concurrency.example.singleton;

import club.lan.concurrency.annoations.NotRecommend;
import club.lan.concurrency.annoations.NotThreadSafe;
import club.lan.concurrency.annoations.ThreadSafe;

/** 懒汉模式--双重同步锁单例模式（不一定线程安全，因为有指令重排）
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  11:37
 */

@NotThreadSafe
@NotRecommend
public class SingletonExample4 {

    private SingletonExample4() { }

    // 当执行实例化时进行三步操作

    //1.memory = allocate() 分配内存空间
    //2.ctorInstance() 初始化对象
    //3.instance = memory 设置instance指向分配的内存

    //在多线程情况下

    //JVM和CPU优化会发生指令重排

    //1.memory = allocate() 分配内存空间
    //3.instance = memory 设置instance指向分配的内存
    //2.ctorInstance() 初始化对象

    //而下面代码中，线程A执行设置instance指向分配的内存，而线程B刚好到if判断，这时候B看到有值了，于是返回引用。但实际上第二步初始化对象还没有做

    //单例对象
    private static SingletonExample4 instance = null;

    //静态的工厂方法
    public static SingletonExample4 getInstance() {
        //双重检测机制
        if (instance==null) {
            synchronized (SingletonExample4.class) { //同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }

        }
        return instance;
    }
}
