package jvm.understanding.ch8;

/**
 * {@link Test8_5} 代码清单8-5 方法静态解析演示
 *
 * $JAVA_HOME_7/bin/javap -verbose jvm/understanding/Test8_5
 */
public class Test8_5 {
    public static void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Test8_5.sayHello();
    }
}
