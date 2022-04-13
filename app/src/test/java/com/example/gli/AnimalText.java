package com.example.gli;

import org.junit.Test;
//        添加必要的构造器，综合应用构造器的重载，this关键字。
//        Boy
//        -name:String
//        -age:int
//        +setName(i: String)
//        +getName(): String
//        +setAge(i: int)
//        +getAge(): int
//        +marry(girl:Girl)
//        +shout():void

public class AnimalText {
    @Test
    public void TreangleTest (){
        Boy boy = new Boy("罗密哦",18);
        Boy boy1 = new Boy("梁山泊",22);
        Boy boy2 = new Boy("叶青",25);
        Girl girl =  new  Girl("朱丽叶",18);
        Girl girl1 =  new  Girl("祝英台",15);
        Girl girl2 =  new  Girl("梁鸿志",20);
        boy.marry(girl);
        girl.marry(boy);
        System.out.println();
        girl1.marry(boy1);
        int compare = girl2.compare(girl1);
        if (compare == 1 ){
            System.out.println(girl2.getName() + "比" + girl1.getName() + "年纪大");
        }else if (compare == 0){
            System.out.println(girl2.getName() + "比" + girl1.getName() + "年纪小");
        }else if (compare == 2){
            System.out.println(girl2.getName() + "与" + girl1.getName() + "一样大");
        }



    }
}
class Boy{

//        +setName(i: String)
//        +getName(): String
//        +setAge(i: int)
//        +getAge(): int
//        +marry(girl:Girl)
//        +shout():void
private String name;
private int age;
public Boy(){
}
public Boy (String name , int age){
    this.name = name;
    this.age = age;
}
public void setName(String name){
    this.name = name;
}
public String getName(){
    return name;
}
public void setAge(int age){
    this.age = age;
}
public int getAge(){
   return age;
}
public void marry(Girl girl){
System.out.println("我想娶" + girl.getName());
}
public void shout(){
if (age < 20){
    System.out.println("你还未到法定结婚年龄");
}else{
    System.out.println("你可以结婚了");
}
}

}
class Girl{
//-name:String
//-age:int
//+setName(i: String)
//+getName(): String
//+marry(boy:Boy)
//+compare(girl:Girl)
    private String name;
    private int age;
    public Girl(){
    }
    public Girl(String name , int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name ){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void marry(Boy boy){
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }
    public int compare(Girl girl){
        if (this.age > girl.age){
            return 1;
        }else if (this.age < girl.age){
            return 0;
        }
         return 2;
    }





}
