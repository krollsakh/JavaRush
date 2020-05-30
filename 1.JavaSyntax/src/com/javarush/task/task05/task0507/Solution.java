package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int sum = 0, count = 0;

        // определяем чтение потока и считывем первое число
        Scanner reader = new Scanner(System.in);
        int readNumber = reader.nextInt();

        // считывае числа до тех пор пока не введено -1
        // все суммируем и запоминаем сколько раз введено
        while (readNumber != -1) {
            sum += readNumber;
            count++;
            readNumber = reader.nextInt();
        }

        System.out.println((double)sum/count);

        reader.close();
    }
}

