package com.example.gli.Exer;

import org.junit.Test;

public class array {

    @Test
    public void main() {
        int[] arr1, arr2;

        arr1 = new int[]{1, 5, 6, 9, 8, 5, 22, 55, 44, 77,};
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }

        System.out.println();
//        arr2=arr1;
//        for (int i = 0; i <arr2.length ; i++) {
//            if(i % 2==0){
//                arr2[i]=i;
//            }
//        }
//        for (int i = 0; i <arr1.length ; i++) {
//            System.out.print(arr2[i]+"\t");
//        }
//        System.out.println();

        arr2 = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[i];
            System.out.print(arr2[i] + "\t");
        }
        System.out.println();

        String[] arr3 = new String[]{"家人", "奴人", "女人"};
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]);
        }
        System.out.println();

        for (int i = 0; i < arr3.length / 2; i++) {
            String tamp = arr3[i];
            arr3[i] = arr3[arr3.length - 1];
            arr3[arr3.length - 1] = tamp;
            System.out.println(arr3[i]);

        }


    }
}