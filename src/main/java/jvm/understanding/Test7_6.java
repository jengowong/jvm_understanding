package jvm.understanding;

/**
 * {@link Test7_6} 代码清单7-6 &lt;clinit&gt;()方法执行顺序
 */
public class Test7_6 {
    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
