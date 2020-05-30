package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        String[] arrayString;
        int[] arrayInt;

        int numInt = 0;
        int numString = 0;

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numInt++;
            } else {
                numString++;
            }
        }

        arrayString = new String[numString];
        arrayInt = new int[numInt];

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                arrayInt[--numInt] = Integer.parseInt(array[i]);
            } else {
                arrayString[--numString] = array[i];
            }
        }

        Arrays.sort(arrayInt);

        if (arrayString.length > 0) {

            String tmp = arrayString[0];
            for (int i = 1; i < arrayString.length; i++) {
                //System.out.println(arrayString[i]);
                if (isGreaterThan(arrayString[i - 1], arrayString[i])) {
                    tmp = arrayString[i];
                    arrayString[i] = arrayString[i - 1];
                    arrayString[i - 1] = tmp;

                    for (int z = i - 1; (z - 1) >= 0; z--) {
                        if (isGreaterThan(arrayString[z - 1], arrayString[z])) {
                            tmp = arrayString[z];
                            arrayString[z] = arrayString[z - 1];
                            arrayString[z - 1] = tmp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        int ixString = 0;
        int ixInt = arrayInt.length-1;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = String.valueOf(arrayInt[ixInt]);
                ixInt--;
            } else {
                array[i] = arrayString[ixString];
                ixString++;
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
