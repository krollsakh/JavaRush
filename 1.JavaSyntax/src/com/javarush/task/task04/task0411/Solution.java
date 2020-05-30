package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
        if (between(month, 3, 5))
            System.out.println("весна");
        else if (between(month, 6, 8)) System.out.println("лето");
        else if (between(month, 9, 11)) System.out.println("осень");
        else System.out.println("зима");
    }

    public static boolean between(int a, int b, int c) {
        return a <= c && a >= b;
    }
}