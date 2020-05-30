package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        TreeSet<Integer> treeSet = new TreeSet<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            treeSet.add(inputStream.read());
        }

        reader.close();
        inputStream.close();

        treeSet.forEach(integer -> System.out.print(integer + " "));

    }
}
