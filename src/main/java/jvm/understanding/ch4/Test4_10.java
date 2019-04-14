package jvm.understanding.ch4;

/**
 * {@link Test4_10} 代码清单4-10 死锁代码样例
 */
public class Test4_10 {
    /**
     * 线程死锁等待演示
     */
    static class SynAddRunnable implements Runnable {
        int a, b;

        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    /**
     * $JAVA_HOME_7/bin/java -Xms100M -Xmx100M -XX:+UseSerialGC jvm/understanding/Test4_10
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }

}
