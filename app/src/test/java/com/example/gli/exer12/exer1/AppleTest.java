package com.example.gli.exer12.exer1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author gsuiy
 * @create 2022-05-01 20:03
 */
public class AppleTest {
    @Test
    public void test1(){
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add( new Apple<String>("500克"));
        apples.add(new Apple<Integer>(500));
        apples.add(new Apple<Double>(500.0));

        Iterator<Apple> iterator = apples.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
