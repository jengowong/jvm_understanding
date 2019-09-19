package jvm.understanding.ch12;

/**
 * {@link Test12_1} 代码清单12-1 volatile的运算
 */
public class Test12_1 {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i].join();
        }

        System.out.println(race);
    }
}
