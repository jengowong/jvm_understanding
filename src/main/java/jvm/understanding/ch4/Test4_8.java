package jvm.understanding.ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Test4_8} 代码清单4-8 JConsole监视代码
 */
public class Test4_8 {
    /**
     * 内存占位符对象，一个OOMObject大约占64K
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    /**
     * $JAVA_HOME_7/bin/java -Xms100M -Xmx100M -XX:+UseSerialGC jvm/understanding/Test4_8
     */
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

}
