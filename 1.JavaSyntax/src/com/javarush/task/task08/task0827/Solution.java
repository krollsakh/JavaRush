package com.javarush.task.task08.task0827;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.MonthDay;
import java.util.*;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date(date));
        return calendar.get(GregorianCalendar.DAY_OF_YEAR) % 2 != 0;
    }
}
