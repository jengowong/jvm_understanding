package jvm.understanding.ch8;

/**
 * {@link Test8_1} 代码清单8-1 局部变量表Slot复用对垃圾收集的影响之一
 */
public class Test8_1 {
    /**
     * $JAVA_HOME_7/bin/java -client -verbose:gc -Xms128M -Xmx128M jvm/understanding/Test8_1
     */
    public static void main(String[] args) {
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
    }
}
