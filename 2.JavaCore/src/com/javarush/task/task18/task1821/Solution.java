package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			TreeMap<Integer, Integer> byteMap = new TreeMap<>();
			String fileName = args[0];
			FileInputStream inputStream = new FileInputStream(fileName);
			while (inputStream.available() > 0) {
				int data = inputStream.read();
				byteMap.merge(data, 1, Integer::sum);
			}
			byteMap.forEach((k, v) -> System.out.println((char) k.intValue() + " " + v));
			inputStream.close();
		}
	}
}
