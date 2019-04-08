package jvm.understanding;

/**
 * {@link Test8_2} 代码清单8-2 局部变量表Slot复用对垃圾收集的影响之二
 */
public class Test8_2 {
    /**
     * $JAVA_HOME_7/bin/java -client -verbose:gc -Xms128M -Xmx128M jvm/understanding/Test8_2
     */
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }
}
