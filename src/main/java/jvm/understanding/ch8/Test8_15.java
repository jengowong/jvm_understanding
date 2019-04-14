package jvm.understanding.ch8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * {@link Test8_15} 代码清单8-15 使用MethodHandle来解决相关问题
 */
public class Test8_15 {
    class GrandFather {
        void thinking() {
            System.out.println("i am grandfatherxxxx");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        @Override
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = MethodHandles.lookup().findSpecial(
                        GrandFather.class,
                        "thinking",
                        mt,
                        getClass());
                mh.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test8_15 test8_15 = new Test8_15();
        Son son = test8_15.new Son();
        son.thinking();
        new Test8_15().new Son().thinking();
        (new Test8_15().new Son()).thinking();
    }
}
