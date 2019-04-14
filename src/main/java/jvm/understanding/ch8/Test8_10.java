package jvm.understanding.ch8;

/**
 * {@link Test8_10} 代码清单8-10 单分派和多分派
 */
public class Test8_10 {
    static class QQ {
    }

    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father f1 = new Father();
        Father f2 = new Son();
        f1.hardChoice(new _360());
        f2.hardChoice(new QQ());
    }
}
