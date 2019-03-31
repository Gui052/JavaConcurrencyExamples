package club.lan.concurrency.example.threadLocal;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/30  13:57
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
