package club.lan.concurrency.example.deal;

/**
 * 按照线程顺序，打印出自己线程相对应的数字
 */
public class PrintNumberOrderThread extends Thread {

    private static volatile int flag = 1;
    private final int name;

    public PrintNumberOrderThread(int name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 10; i++) {
            threads[i - 1] = new Thread(new PrintNumberOrderThread(i), String.valueOf(i));
        }
        for (int i = 1; i <= 10; i++) {
            threads[i - 1].start();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (flag == name) {
                synchronized (this) {
                    System.out.println("thread " + name);
                    flag = flag + 1;
                }
                break;
            }
        }
    }
}


