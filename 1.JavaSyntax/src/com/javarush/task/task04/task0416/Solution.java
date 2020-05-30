package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import javax.swing.text.SimpleAttributeSet;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //Считываем строку с клавиатуры (не проверяем правильность ввода, подразумеваем, что ввели вещественное число
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Double t = Double.valueOf(s) % 5;

        if (t < 3) {
            System.out.println("зелёный");
        } else if (t < 4) {
            System.out.println("жёлтый");
        } else {
            System.out.println("красный");
        }

    }
}