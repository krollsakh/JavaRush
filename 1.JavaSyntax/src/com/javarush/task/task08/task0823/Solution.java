package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        StringBuilder stringBuilder = new StringBuilder(string);

        // Меняем первый символ на заглавный
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));

        int i = stringBuilder.indexOf(" ", 1);
        while (i != -1 && i < stringBuilder.length()-1) {
            stringBuilder.setCharAt(i+1, Character.toUpperCase(stringBuilder.charAt(i+1)));
            i = stringBuilder.indexOf(" ", i+1);
        }
        System.out.println(stringBuilder);
    }
}
