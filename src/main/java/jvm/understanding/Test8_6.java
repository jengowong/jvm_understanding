package jvm.understanding;

/**
 * {@link Test8_6} 代码清单8-6 方法静态分派演示
 */
public class Test8_6 {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human humanMan = new Man();
        Human humanWoman = new Woman();
        Man man = new Man();
        Woman woman = new Woman();
        Test8_6 sr = new Test8_6();
        sr.sayHello(humanMan);
        sr.sayHello(humanWoman);
        sr.sayHello(man);
        sr.sayHello(woman);
    }

}
