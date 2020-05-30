package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int positiv = 0, negativ = 0;
        int number;
        for (int i = 0; i < 3; i++) {
            number = Integer.valueOf(reader.readLine());
            if (number == 0) continue;
            else if (number > 0) positiv++;
            else negativ++;
        }
        System.out.println("количество отрицательных чисел: " + negativ);
        System.out.println("количество положительных чисел: " + positiv);
    }
}
