package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        int commaCount = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(file);

        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 44) {
                commaCount++;
            }
        }

        fileInputStream.close();

        System.out.println(commaCount);
    }
}
