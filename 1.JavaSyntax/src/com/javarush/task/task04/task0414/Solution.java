package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        //Считываем с клавиатуры год

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int year = Integer.valueOf(s);
        int countDaysInYear = 0;
        int isVisok = (year % 400 == 0 || (year % 4 == 0) && (year % 100 != 0)) ? 6: 5;

        // определяем високосный
        System.out.print("количество дней в году: 36" + isVisok);
       // System.out.println(((year % 400 = 0) || (year % 4 = 0 && year % 100 != 0)) ? 6: 5);

    }
}