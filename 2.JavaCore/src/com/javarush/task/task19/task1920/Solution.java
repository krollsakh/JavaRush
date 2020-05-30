package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) throws IOException {

		TreeMap<String, Double> lines = new TreeMap<>();
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] data = line.split(" ");
			Double current = Double.parseDouble(data[1]);
			lines.merge(data[0], current, Double::sum);
		}
		reader.close();

		double maxValue = Collections.max(lines.values());

		lines.entrySet().forEach(e -> {
			String k = e.getKey();
			Double v = e.getValue();
			if (v.equals(maxValue)) {
				System.out.println(k);
			}
		});
	}
}
