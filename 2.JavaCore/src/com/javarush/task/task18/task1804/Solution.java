package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        HashMap<Integer, Integer> byteMap = new HashMap<Integer, Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            byteMap.merge(data, 1, (oldValue, newValue) -> oldValue + newValue);
        }

        inputStream.close();
        reader.close();

        int maxValues = Collections.min(byteMap.values());
        byteMap.forEach((k,v) -> {if (v == maxValues) System.out.print(k + " ");});

    }
}
