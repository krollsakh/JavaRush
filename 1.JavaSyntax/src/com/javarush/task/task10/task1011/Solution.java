package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < 40; i++) {
            System.out.println(sb.substring(i));
        }
    }

}

