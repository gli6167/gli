package com.example.gli.exer12;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author gsuiy
 * @create 2022-05-01 19:14
 *
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（TreeSet 需使用泛型
 * 来定义），
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 继承 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序
 */
public class TreeSetTest1 {
@Test
public void test1(){
    TreeSet <Employee> treeSet = new TreeSet<>(new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            MyDate b1 = o1.getBirthday();
            MyDate b2 = o2.getBirthday();
            int i1 = b1.getYear() - b2.getYear();
            if (i1 != 0){
                return i1;
            }
            int i2 = b1.getMonth() - b2.getMonth();
            if (i2!=0){
                return i2;
            }
            return b1.getDay()-b2.getDay();
        }
    });
    treeSet.add(new Employee("gll",30,new MyDate(1990,10,15)));
    treeSet.add(new Employee("gsy",25,new MyDate(1995,3,24)));
    treeSet.add(new Employee("ldh",50,new MyDate(1999,4,18)));
    treeSet.add(new Employee("jnh",40,new MyDate(1988,10,13)));
    treeSet.add(new Employee("kjh",30,new MyDate(1997,12,15)));
    Iterator<Employee> iterator = treeSet.iterator();
    while (iterator.hasNext()){
        System.out.println(iterator.next());
    }
}
}
