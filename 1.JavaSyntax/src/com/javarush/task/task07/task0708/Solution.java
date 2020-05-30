package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>();
        int max = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
            max = Math.max(max, strings.get(i).length());
        }

        for (int i = 0; i < 5; i++) {
            if (strings.get(i).length() == max) {
                System.out.println(strings.get(i));
            }
        }
    }
}
