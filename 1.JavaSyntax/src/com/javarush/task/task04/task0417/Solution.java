package com.javarush.task.task04.task0417;

/*
Существует ли пара?
*/

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		//напишите тут ваш код
		Scanner scanner = new Scanner(System.in);
		int a1 = scanner.nextInt();
		int a2 = scanner.nextInt();
		int a3 = scanner.nextInt();
		if (a1 == a2) {
			System.out.print(a1 + " " + a2);
			if (a1 == a3) System.out.print(" " + a1);
		} else if (a1 == a3 || a2 == a3) {
			System.out.print(a3 + " " + a3);
		}
	}
}