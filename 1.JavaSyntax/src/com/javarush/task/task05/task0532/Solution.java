package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int col = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;
        int number = 0;
        col = Integer.parseInt(reader.readLine());
        if (col <= 0) {
            System.out.println("0");
            return;
        }
        for (int i = 0; i < col; i++) {
            number = Integer.parseInt(reader.readLine());
            if (maximum < number) maximum = number;
        }

        System.out.println(maximum);
    }
}
