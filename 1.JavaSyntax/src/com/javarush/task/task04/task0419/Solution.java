package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int a3 = scanner.nextInt();
        int a4 = scanner.nextInt();

        System.out.println(max(max(a1, a2), max(a3, a4)));

    }
    private static int max (int a1, int a2) {
        if (a1 > a2) {
            return a1;
        } else if (a1 < a2) {
            return a2;
        }
        return a1;
    }
}
