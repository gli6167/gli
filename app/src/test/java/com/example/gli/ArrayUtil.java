package com.example.gli;

import android.net.IpSecManager;

import org.junit.Test;
//      求数组的最大值  完成
//      求数组的最小值  完成
//      求数组的平均值  完成
//      求数组的总和    完成
//      反转数组       完成
//      数组排序       完成
//      遍历数组       完成
//      查找指定元素    完成

public class ArrayUtil {


    @Test
    public void main() {
        int[] arr1 = new int[]{99, 5, 44, 8, 22, 1, 3, 0};

        ArrayUtil texr = new ArrayUtil();
        texr.print(arr1);
        System.out.println(texr.Max(arr1));
        System.out.println(texr.Sum(arr1));
        System.out.println(texr.Min(arr1));
        System.out.println(texr.Aver(arr1));
        System.out.println(texr.Sear(arr1,44));
        texr.Sort(arr1);
        texr.print(arr1);
        texr.Revw(arr1);
        texr.print(arr1);

    }





    /**
     * 遍历int型的数组
     *
     * @param arr
     */
    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 找到int型的数组的最大值
     *
     * @param arr
     */
    public int Max(int[] arr) {
        int Max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (Max < arr[i]) {
                Max = arr[i];
            }
        }
        return Max;
    }

    /**
     * 找到int型的数组的最小值
     *
     * @param arr
     */
    public int Min(int[] arr) {
        int Min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (Min > arr[i]) {
                Min = arr[i];
            }
        }
        return Min;
    }

    /**
     * 求数组的总和
     *
     * @param arr
     */
    public int Sum(int[] arr) {
        int Sum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            Sum += arr[i];
        }
        return Sum;
    }

    /**
     * 求数组的平均数
     *
     * @param arr
     */
    public int Aver(int[] arr) {
        return Sum(arr) / arr.length;
    }

    /**
     * 反转数组
     *
     * @param arr
     */
    public void Revw(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 数组排序从小到大
     *
     * @param arr
     */
    public void Sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 从数组中找到一个数
     *
     * @param arr
     */

    public int Sear(int[] arr, int j) {
        int Query = j;
        for (int i = 0; i < arr.length; i++) {
            if (Query == arr[i]) {
                return i; //返回数字的下标
            }
        }
        return -1;//表示没有找到
    }
}

