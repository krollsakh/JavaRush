package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Integer.valueOf(reader.readLine()) > 0) count++ ;
        }
        System.out.println(count);
    }
}
