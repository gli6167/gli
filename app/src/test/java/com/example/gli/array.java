package com.example.gli;

import org.junit.Test;

public class array {

    @Test
    public void count(){
        int[] array = {1,3,5,7,9};
        for (int i = 0; i < array.length; i++) {
            System.out.println("i = "+array[i]);
        }
    }
}
