package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int odd = 0;
        int even = 0;
        int[] ints = new int[15];
        for (int i = 0; i < 15; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ints[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0) {
                odd += ints[i];
            } else {
                even += ints[i];
            }
        }
        System.out.println("В домах с " + (odd > even ? "" : "не") + "четными номерами проживает больше жителей.");
    }
}
