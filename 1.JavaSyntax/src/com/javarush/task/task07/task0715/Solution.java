package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "мама", "мыла", "раму");

        for (int i = 0; i < list.size(); i++) {
            list.add(++i, "именно");
        }

        list.forEach(System.out::println);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
}
