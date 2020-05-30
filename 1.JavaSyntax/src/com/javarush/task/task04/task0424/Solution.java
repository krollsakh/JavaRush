package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int a3 = scanner.nextInt();
        int num = 0;

        // сначала выясним есть ли одинаковые
        if (a1 == a2 && a3 != a1) {
            System.out.println("3");
        } else if (a1 == a3 && a2 != a3) {
            System.out.println("2");
        } else if (a2 == a3 && a1 != a2) {
            System.out.println("1");
        }
    }
}
