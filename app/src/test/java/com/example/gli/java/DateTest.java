package com.example.gli.java;

import com.example.gli.bean.Person;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * @author gsuiy
 * @create 2022-04-27 20:28
 */
public class DateTest {

    @Test
    public void test() {
        // 2022-04-27
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //  20:43:02.754635300
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        //  2022-04-27T20:44:37.185697600
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
        System.out.println("localDateTime：" + localDateTime);

        LocalDateTime localDateTime2 = LocalDateTime.now().plusDays(2);
        System.out.println("localDateTime2：" + localDateTime2);
        System.out.println("localDateTime2：秒" + localDateTime2.toInstant(ZoneOffset.of("+8")).toEpochMilli());

        Temporal temporal = localDateTime.adjustInto(localDateTime2);
        System.out.println("localDateTime2：" + temporal);
        System.out.println("localDateTime：" + localDateTime);

        // System.currentTimeMillis()
        Instant instant = Instant.now();
        System.out.println("instant: " + instant);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println("format：" + formatter.format(localDateTime2));

        String c[] = {"p", "e", "o", "p", "l", "e"};
        String s = "people";
        String t = "people";
        String f = new String("people");
        System.out.println(s.equals(c));
        System.out.println(s == t);
        System.out.println(t == f);

        Person person1 = new Person("tom");
        Person person2 = new Person("tom");
        System.out.println(person1.name == person2.name);


    }
}