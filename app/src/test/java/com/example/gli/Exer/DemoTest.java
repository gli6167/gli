package com.example.gli.Exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

public class DemoTest {



    @Test
    public void test() {
//        method(5);

        extracted();

    }

    private void extracted() {
        int i = 0;
        change(i);
        i = ++i;
        System.out.println("i = " + i);
        System.out.println(i+5);
    }

    public static void change(int i){
        i++;
    }

    int x = 12;

    public void method(int x) {
//        x += x;
        x = this.x + x;
        System.out.println(x);
    }

//    A. 5
//    B. 10
//    C. 12
//    D. 17
//    E. 24

}
