package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int i = Integer.valueOf(s);

        if (i > 0) System.out.println(i * 2);
        else if (i < 0) System.out.println(++i);
        else System.out.println(0);

   }

}