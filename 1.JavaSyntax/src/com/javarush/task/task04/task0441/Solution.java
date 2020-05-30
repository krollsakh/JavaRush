package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int max = 0;
        int min = 0;
        int result = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.valueOf(reader.readLine());
        int num2 = Integer.valueOf(reader.readLine());
        int num3 = Integer.valueOf(reader.readLine());

        if (num1 > num2 ) {
            max = num1;
            min = num2;
        } else {
            max = num2;
            min = num1;
        }

        if (num3 >= max) {
            result = max;
        } else if (num3 >= min) {
            result = num3;
        } else {
            result = min;
        }

        System.out.println(result);
    }
}
