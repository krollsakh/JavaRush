package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Минимальный байт
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		int minByte = Integer.MAX_VALUE;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		FileInputStream inputStream = new FileInputStream(fileName);
		while (inputStream.available() > 0) {
			int data = inputStream.read();
			minByte = (minByte < data) ? minByte : data;
		}
		inputStream.close();
		reader.close();

		System.out.println(minByte);
	}
}
