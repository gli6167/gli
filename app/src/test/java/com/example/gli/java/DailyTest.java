package com.example.gli.java;

import androidx.annotation.NonNull;

import org.junit.Test;

public class DailyTest {

    static int x, y, z;

    static {
        int x = 5;
        x--;
    }

    static {
        x--;
    }

    @Test
    public void main3() {
        main();
        System.out.println("main3：" + z);
    }

    public void main() {
        main2();
        System.out.println("main：" + z);

    }

    public void main2() {
        z = z--;

        int a = 0;
        a = a + 1;

        // todo
        System.out.println("开始z " + z);
        System.out.println("开始y " + y);
        method();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public void method() {
//        System.out.println("z=" + z);
//        y = (z++) + (++z);
//        System.out.println("y=" + y);
//
//        System.out.println("z=" + z);

    }


    @Test
    public void test() {
        int x = 10;
        System.out.println(x);
        Integer.valueOf(145);

        // 自动拆箱
        Integer i1 = new Integer(145);
//        Integer i1 =145;
        int i2 = 145;
        System.out.println(i2 == i1);


        int i3 = 100;
        int i4 = 100;
        System.out.println(i3 == i4);


        // IntegerCache缓存池查找 -128-127
        Integer i5 = 115;
        Integer i6 = 115;
        System.out.println(i5 == i6);

        // 自动装箱 Integer.valueOf(int)
        Integer i7 = 200;
        Integer i8 = 200;
        System.out.println(i7 == i8);

        testField(new Fu());
        testField(new Demo());

        Fu fu = new Fu();
        Fu fu2 = new Demo();
        Demo fu3 = new Demo();


    }

    public void testField(Fu fu) {
        int i = 0;
        Fu f = new Demo();
        Demo d = new Demo();
        for (f.show('A'); f.show('B') && (i < 2); f.show('C')) {
            i++;
            d.show('D');
        }
    }

    public void suspend() {
        String username = null;
        if (username.equals("admin")) {
            System.out.println("==============");
        }
    }
}


class Demo extends Fu {
    boolean show(char a) {
        System.out.println(a);
        return false;
    }

    public void ddd() {
    }
}

class Demo2 extends Fu {
    public Demo2(String a) {
        super();
    }

    boolean show(char a) {
        System.out.println(a);
        return false;
    }

    public void ddd() {
    }
}


class Fu {
    boolean show(char a) {
        System.out.println(a);
        return true;
    }

}



