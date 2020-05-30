package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		TreeMap<String, Double> lines = new TreeMap<>();
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] data = line.split(" ");
			lines.merge(data[0], Double.parseDouble(data[1]), Double::sum);
		}
		reader.close();
		lines.forEach((a, b) -> System.out.println(a + " " + b));
	}
}
