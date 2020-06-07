package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> treeSet = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        int c;
        while ((c = reader.read()) != -1) {
            if (c > 64 && c < 123) {
                treeSet.add(Character.toLowerCase((char) c));
            }
        }
        reader.close();

        int i = 0;
        for (char ch : treeSet) {
            if (i == 5) {
                break;
            }
            System.out.print(ch);
            i++;
        }
    }
}
