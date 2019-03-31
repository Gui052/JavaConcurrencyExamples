package club.lan.concurrency.example.singleton;

import club.lan.concurrency.annoations.Recommend;
import club.lan.concurrency.annoations.ThreadSafe;

/** 枚举模式，最安全的
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  12:11
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只允许调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton() {
            return singleton;
        }
    }
}
