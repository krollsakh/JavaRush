package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Первая строка");
        list.add("Вторая строка");
        list.add("Третья строка");
        list.add("Четвертая строка");
        list.add("Пятая строка");

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
