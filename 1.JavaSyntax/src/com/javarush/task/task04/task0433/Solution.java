package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int count2 = 0, count = 0;
        while (count2 < 10) {
            count = 0;
            count2++;
            while (count < 10) {
                count++;
                System.out.print("S");
            }
            System.out.println();
        }
    }
}
