package jvm.understanding.ch8;

/**
 * {@link Test8_14} 代码清单8-14 方法调用问题
 */
public class Test8_14 {
    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            // 请读者在这里填入适当的代码（不能修改其他地方的代码）
            // 实现调用祖父类的thinking()方法，打印"i am grandfather"
        }
    }
}
