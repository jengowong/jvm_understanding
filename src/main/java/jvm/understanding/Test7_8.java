package jvm.understanding;

import java.io.IOException;
import java.io.InputStream;

/**
 * {@link Test7_8} 代码清单7-8 不同的类加载器对instanceof关键字运算结果的影响
 */
public class Test7_8 {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Class cl = myLoader.loadClass("jvm.understanding.Test7_8");
        Object obj1 = cl.newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1.getClass().equals(cl));
        System.out.println(obj1 instanceof jvm.understanding.Test7_8);
        Object obj2 = new Test7_8();
        System.out.println(obj2 instanceof jvm.understanding.Test7_8);
    }
}
