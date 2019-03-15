package jvm.understanding;

/**
 * {@link Test3_6} 代码清单3-6 大对象直接进入老年代
 */
public class Test3_6 {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     * $JAVA_HOME_7/bin/java -client -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 jvm/understanding/Test3_6
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

}
