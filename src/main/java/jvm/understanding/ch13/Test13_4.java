package jvm.understanding.ch13;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link Test13_4}
 */
public class Test13_4 {

    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
        race.incrementAndGet();
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

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i].join();
        }
        System.out.println(race);
    }

}
