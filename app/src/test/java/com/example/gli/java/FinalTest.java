package com.example.gli.java;

import org.junit.Test;

/**
 * @author gsuiy
 * @create 2022-04-24 22:40
 */
public class FinalTest {

    @Test
    public void test() {
        Other o = new Other();
        addOne(o);
    }

    public void addOne(final Other o) {
        o.i++;



    }
}

class Other {
    public   int i;
}

