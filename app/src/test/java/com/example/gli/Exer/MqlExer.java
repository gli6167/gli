package com.example.gli.Exer;

//编写程序，定义三个重载方法并调用。方法名为mOL。
//        三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别
//        执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
//        在主类的main ()方法中分别用参数区别调用三个方法。
//        3.定义三个重载方法max()，第一个方法求两个int值中的最大值，第二个方
//        法求两个double值中的最大值，第三个方法求三个double值中的最大值，
//        并分别调用三个方法。

import org.junit.Test;

public class MqlExer {

    @Test
    public void tesr(){
        Exer text = new Exer();
        text.mQL(5);
        text.mQL(5,4);
        text.mQL("你好");
        System.out.println();
        System.out.println(text.max(5,9));
        System.out.println(text.max(11.5,16.8));
        System.out.println(text.max(12.6,42.66,15.6));

    }


class Exer {
    public void mQL(int m) {
        int square = m * m;
        System.out.println(square);
    }

    public void mQL(int m, int n) {
        int product = m * n;
        System.out.println(product);
    }

    public void mQL(String m) {
        System.out.println(m);
    }
    public int max(int i,int j){
        if(i>j){
           return i;
        }
        return j;
    }
    public double max(double i, double j){
      return ((i > j) ? i : j);
    }
    public double max(double i , double j , double m){
       return ( ( ( ( i>j ) ? i:j ) > m ) ? ( ( i>j ) ? i:j ) : m );
    }



}


}
