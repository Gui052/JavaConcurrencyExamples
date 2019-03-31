package club.lan.concurrency.example.publish;

import club.lan.concurrency.annoations.NotRecommend;
import club.lan.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/** 对象逸出
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  11:18
 */
//在对象未完成构造之前不允许发布，下面代码可能产生逸出
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBescape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBescape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
