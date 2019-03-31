package club.lan.concurrency.example.publish;

import club.lan.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/** 发布对象
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  11:14
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.states));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.states));

    }
}
