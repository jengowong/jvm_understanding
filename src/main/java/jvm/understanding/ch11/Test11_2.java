package jvm.understanding.ch11;

/**
 * {@link Test11_2} 代码清单11-2 测试代码
 *
 * $JAVA_HOME_7/bin/java -client -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xms128M -Xmx128M jvm/understanding/ch11/Test11_2
 */
public class Test11_2 {
    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        // 这个空循环用于后面演示JIT代码优化过程
        for (int j = 0; j < 100000; j++) ;
        return i * 2;
    }

    public static long calcSum() {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }
}
