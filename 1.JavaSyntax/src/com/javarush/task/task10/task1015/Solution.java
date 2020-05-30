package com.javarush.task.task10.task1015;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] arr = new ArrayList[2];

        arr[0] = new ArrayList<String>(){{
            add("A");
            add("B");
            add("c");
        }};
        arr[1] = new ArrayList<String>(){{
            add("d");
            add("e");
            add("f");
        }};

        return arr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}