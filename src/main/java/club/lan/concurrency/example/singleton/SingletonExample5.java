package club.lan.concurrency.example.singleton;

import club.lan.concurrency.annoations.NotRecommend;
import club.lan.concurrency.annoations.ThreadSafe;

/** 懒汉模式--双重同步锁单例模式（使用volatile关键字禁止指令重排）
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  11:37
 */
@ThreadSafe
@NotRecommend
public class SingletonExample5 {

    private SingletonExample5() { }

    // 当执行实例化时进行三步操作

    //1.memory = allocate() 分配内存空间
    //2.ctorInstance() 初始化对象
    //3.instance = memory 设置instance指向分配的内存


    //单例对象 volatile+双重检测机制->禁止指令重排
    private volatile static SingletonExample5 instance = null;

    //静态的工厂方法
    public static SingletonExample5 getInstance() {
        //双重检测机制
        if (instance==null) {
            synchronized (SingletonExample5.class) { //同步锁
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }

        }
        return instance;
    }
}
