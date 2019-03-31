package club.lan.concurrency.example.immutable;

import club.lan.concurrency.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
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
public class ImmutableExample3 {
    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);
    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer,Integer>builder()
            .put(1, 2)
            .put(3, 4)
            .build();

    public static void main(String[] args) {
        System.out.println(map2.get(3));
    }
}
