package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //System.out.print("Введите число a: ");
        int a = Integer.valueOf(bufferedReader.readLine());
        //System.out.print("Введите число b: ");
        int b = Integer.valueOf(bufferedReader.readLine());
        //System.out.print("Введите число c: ");
        int c = Integer.valueOf(bufferedReader.readLine());

        if (a + b > c && a + c > b && c + b > a) System.out.println("Треугольник существует.");
        else System.out.println("Треугольник не существует.");

    }
}