package com.javarush.task.task04.task0427;

/*
Описываем числа
*/

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		//ввод числа
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		// проверка диапазона
		if (num < 1 || num > 999) return;

		// четный/нечетный ?
		System.out.print((num % 2 == 0 ? "четное " : "нечетное "));

		// сколько знаков ?
		switch (Integer.toString(num).length()) {
			case 1:
				System.out.print("одно");
				break;
			case 2:
				System.out.print("дву");
				break;
			case 3:
				System.out.print("трех");
				break;
		}
		System.out.println("значное число");
	}
}
