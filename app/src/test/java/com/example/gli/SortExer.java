package com.example.gli;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class SortExer {
    @Test
    public void main() {
        int[] arr1 = new int[]{5, 8, 9, 3, 1, 7, 4, 6, 2};
        for (int i = 0; i < arr1.length; i++) {
            int minpos = i;
            for (int j = i+1; j < arr1.length; j++) {
                if (arr1[j] < arr1[minpos]) {
                    minpos = j;
                }
            }
//            System.out.println("最小值的下标在 " + minpos);
            exchange(arr1,i,minpos);

        }
        print(arr1);
    }

    public void exchange(int [] arr1,int i,int j){
        int temp = arr1[i];
        arr1[i] = arr1[j];
        arr1[j] = temp;
    }



    public void print(int []arr1){
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }
}