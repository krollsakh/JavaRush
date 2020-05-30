package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        int[] ints = new int[20];
        ints[0] = Integer.parseInt(reader.readLine());
        maximum = ints[0];
        minimum = ints[0];

        for (int i = 1; i < 20; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
            if (maximum < ints[i]) maximum = ints[i];
            if (minimum > ints[i]) minimum = ints[i];
        }

        System.out.print(maximum + " " + minimum);
    }
}
