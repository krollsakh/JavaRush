package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		//напишите тут ваш код
		Scanner scanner = new Scanner(System.in);
		int a1 = scanner.nextInt();
		int a2 = scanner.nextInt();
		int a3 = scanner.nextInt();

		if (a1 > a2) {
			if (a1 > a3) {
				System.out.print(a1 + " ");
				if (a2 > a3) {
					System.out.print(a2 + " " + a3);
				} else {
					System.out.print(a3 + " " + a2);
				}
			} else {
				System.out.println(a3 + " " + a1 + " " + a2);
			}
		} else { //a2 > a1
			if (a2 > a3) {
				System.out.print(a2 + " ");
				if (a3 > a1) {
					System.out.print(a3 + " " + a1);
				} else {
					System.out.print(a1 + " " + a3);
				}
			} else {
				System.out.println(a3 + " " + a2 + " " + a1);
			}
		}

	}

}
