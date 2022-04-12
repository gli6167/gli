package com.example.gli;

import org.junit.Test;

/**
 * 测试switch
 */
public class SwitchTest {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println("开始 " + i);
            // 方法调用完成之后退出
            int back = testSwitch(i);
            System.out.println("结束 " + i);
        }

        System.out.println("-------------");

        int[] array = new int[]{1, 2, 3};
        testArray(array);
    }

    /**
     * 方法或者函数
     *
     * @param number
     * @return
     */
    @Test
    public int testSwitch(int number) {
        switch (number) {
            case 1:
                System.out.println("一");
                break;
            case 2:
                System.out.println("二");
                break;
            case 3:
                System.out.println("三");
                break;
            case 4:
                System.out.println("四");
                break;
            case 5:
                System.out.println("五");
                break;
            case 6:
                System.out.println("六");
                break;
            default:
                System.out.println("错误");
        }

        return -1;
    }

    public void testArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
