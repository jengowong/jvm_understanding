package jvm.understanding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * {@link Test4_11} 代码清单4-11 BTrace跟踪演示
 */
public class Test4_11 {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        Test4_11 test = new Test4_11();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
        }
    }

}
