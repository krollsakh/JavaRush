package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numList = new int[5];

        for (int i = 0; i < 5; i++) {
            numList[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(numList);
        //numList.sort();

        for (int num : numList) {
            System.out.println(num);
        }
    }
}
