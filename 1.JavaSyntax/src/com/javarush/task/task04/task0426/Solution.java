package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 0) {
            System.out.println("ноль");
            return;
        }
         System.out.println((number < 0 ? "отрицательное" : "положительное") + " " + (number % 2 == 0 ? "" : "не") + "четное число");
    }
}
