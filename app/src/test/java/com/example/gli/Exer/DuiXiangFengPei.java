package com.example.gli.Exer;

import org.junit.Test;

import java.util.Objects;

/**
 * 测试对象赋值和分配空间
 */
public class DuiXiangFengPei {

    @Test
    public void test() {
        first();
    }

    public void first() {
        int i = 5;
        String s = new String("abc");
        String s2 = new String("abc");
        Value v = new Value();
        v.i = 25;
        second(v, i, s);
        System.out.println(v.i);
        System.out.println("s = " + s);
    }

    /**
     * @param v1
     * @param i
     */
    public void second(Value v1, int i, String s1) {
        System.out.println("v = " + v1);
        System.out.println("v.i = " + v1.i);
        System.out.println("i = " + i);
        System.out.println("------------");
        i = 0;
        System.out.println("v = " + v1);
        System.out.println("v.i = " + v1.i);
        System.out.println("i = " + i);
        System.out.println("------------");
        v1.i = 20;
        System.out.println("v = " + v1);
        System.out.println("v.i = " + v1.i);
        System.out.println("i = " + i);
        System.out.println("------------");
        Value val = new Value();
        v1 = val;
        System.out.println("v = " + v1);
        System.out.println("v.i = " + v1.i);
        System.out.println("i = " + i);
        System.out.println("------------");

        System.out.println("s1 = " + s1);
        s1 = "def";
        System.out.println("s1 = " + s1);

    }

    class Value {
        int i = 15;

        @Override
        public int hashCode() {
            return Objects.hash(i);
        }
    }
}


