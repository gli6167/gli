package com.example.gli.Exer.Day14.Exer2;
//)定义类Kids继承ManKind，并包括
//        成员变量int yearsOld；


public class Kids extends ManKind {
    private int yearsOld;
    public Kids(){}
    public Kids(int sex , int salary , int yearsOld){
        super(sex,salary);
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
    //        方法printAge()打印yearsOld的值。
    public void printAge(){
        System.out.println("年龄为：" + yearsOld);
    }

    @Override
    public void employeed() {
        super.employeed();
        System.out.println("but Kids should study and no job.");
    }
}
