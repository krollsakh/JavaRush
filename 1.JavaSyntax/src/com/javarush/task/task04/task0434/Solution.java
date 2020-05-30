package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int row = 0;
        while (row < 10) {
            int col = 0;
            row++;
            while (col < 10) {
                col++;
                System.out.print(row * col + " ");
            }
            System.out.println();
        }
    }
}
