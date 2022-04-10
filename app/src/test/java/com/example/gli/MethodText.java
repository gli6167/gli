package com.example.gli;

import org.junit.Test;

//       定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩
//        score(int)。 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
//        问题一：打印出3年级(state值为3）的学生信息。
//        问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息

public class MethodText {
    @Test
    public void Text(){
//        新键一个对象,创建20个学生对象
       Student [] stus = new Student [20];

        for (int i = 0; i <stus.length ; i++) {
//            给元素赋值
            stus[i] = new Student() ;
            stus[i].number = i+1;
            stus[i].state =(int) (Math.random()*(6-1+1)+1);
            stus[i].score = (int)(Math.random()*(100-0+1)+0);
        }
        bao text=new bao();
//        打印出学生信息
        text.print(stus);
        System.out.println("**********");
//        根据学生成绩从小到达排序并打印学生信息
        text.sort(stus);
        text.print(stus);
        System.out.println("**********");
//        根据给定的学生年级打印学生信息
        text.m(stus,6);
    }

}
class bao{
    //    遍历数组并输出学生信息
    public void print(Student[]stus){
        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i].into());
        }
    }
    //    打印出年级(state值）的学生信息。
    public void m(Student[] stus,int state){
        for (int i = 0; i <stus.length ; i++) {
            if (stus[i].state == state){
                System.out.println(stus[i].into());
            }
        }
    }
    //    数组冒泡排序，从小到大
    public void sort(Student[]stus){
        for (int i = 0; i <stus.length-1 ; i++) {
            for (int j = 0; j <stus.length - 1 - i ; j++) {
                if(stus[j].score > stus[j+1].score){
                    Student temp = stus[j];
                    stus[j] = stus[j+1];
                    stus[j+1] = temp;
                }
            }
        }
    }
}

class Student {
//    定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩
    int number;   //学号
    int state;    //年级
    int score;    //成绩

// 输出学生信息
    public String into(){
        return"学号为；" + number + "\t年级为：" + state + "\t成绩为：" + score;
    }
}