package club.lan.concurrency.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  13:02
 */
@Slf4j
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();
    static {
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 5);
    }

    public static void main(String[] args) {
        //a=2;
        //b="2";
        //map=newHashMap();
        map.put(1, 3);
        log.info("{}", map.get(1));//尽管map引用不可变，但是里面的值可以
    }
}
