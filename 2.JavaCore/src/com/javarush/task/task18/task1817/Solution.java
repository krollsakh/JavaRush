package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			int numSpaces = 0;
			FileInputStream fileInputStream = new FileInputStream(args[0]);
			int numSummary = fileInputStream.available();
			while (fileInputStream.available() > 0) {
				int data = fileInputStream.read();
				numSpaces = numSpaces + ((data == ' ') ? 1 : 0);
			}

			float result = (float) numSpaces / numSummary * 100;

			System.out.printf("%.2f", result);

			fileInputStream.close();
		}
	}
}
