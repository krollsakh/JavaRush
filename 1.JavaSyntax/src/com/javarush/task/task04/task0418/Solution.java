package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();

        if (a1 == a2) {
            System.out.println(a1);
        } else if (a1 < a2) {
            System.out.println(a1);
        } else {
            System.out.println(a2);
        }
    }
}