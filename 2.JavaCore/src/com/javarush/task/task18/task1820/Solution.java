package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		// Чтение имен файлов
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName1 = reader.readLine();
		String fileName2 = reader.readLine();

		//Чтение чисел, разделенных пробелом из файла 1 с одновременной записью в файл 2 (строка преобразуется во Double, который округляется по правилам Math.round()
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
		BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2)));
		String line;
		while ((line = fileReader.readLine()) != null) {
			for (String numStr: line.split(" ")) {
				fileWriter.write(String.valueOf(Math.round(Double.parseDouble(numStr))) + " ");
			}
		}

		// Закрытие потоков
		reader.close();
		fileReader.close();
		fileWriter.flush();
		fileWriter.close();
	}
}
