package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Максимальный байт
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		int maxByte = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = reader.readLine();
		FileInputStream inputStream = new FileInputStream(fileName);
		while (inputStream.available() > 0) {
			int data = inputStream.read();
			maxByte = (maxByte > data) ? maxByte : data;
		}
		inputStream.close();
		reader.close();

		System.out.println(maxByte);
	}
}
