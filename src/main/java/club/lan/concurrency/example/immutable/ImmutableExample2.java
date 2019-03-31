package club.lan.concurrency.example.immutable;

import club.lan.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  13:02
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {
    private final static Integer a = 1;
    private final static String b = "2";
    private static Map<Integer, Integer> map;
    static {
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 5);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);  //抛出异常，不能让值被更改
        log.info("{}", map.get(1));
    }
}
