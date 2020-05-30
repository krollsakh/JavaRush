package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());

		if(a <= 0 || b <= 0) throw new Exception();

		int nod = a < b ? a : b;

		while (true) {
			if (a % nod == 0 && b % nod == 0) {
				break;
			} else {
				nod--;
			}
		}

		System.out.println(nod);

	}
}
