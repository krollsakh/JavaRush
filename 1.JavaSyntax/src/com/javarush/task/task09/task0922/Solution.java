package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd"); // формат даты который будут вводить
        Date date = simpleDateFormat1.parse(reader.readLine()); // преобразование введенного в дату

        // вывод даты в другом формате
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(simpleDateFormat2.format(date).toUpperCase());
    }
}
