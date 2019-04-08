package jvm.understanding;

/**
 * {@link Test8_3} 代码清单8-3 局部变量表Slot复用对垃圾收集的影响之三
 */
public class Test8_3 {
    /**
     * $JAVA_HOME_7/bin/java -client -verbose:gc -Xms128M -Xmx128M jvm/understanding/Test8_3
     */
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}