package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) throws IOException {
		// Чтение имен файлов
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName1 = reader.readLine();
		String fileName2 = reader.readLine();

		// Чтение содержимого 2 файла
		BufferedReader fileReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1), "windows-1251"));
		ArrayList<String> fileContent = new ArrayList<>();
		String line;
		while ((line = fileReader1.readLine()) != null) {
			fileContent.add(line);
		}

		// Создание потока для записи в файл (он должен быть один!)
		BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName1), "windows-1251"));

		// Чтение второго файла и запись содержимого в первый файл
		BufferedReader fileReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2), "windows-1251"));
		while ((line = fileReader2.readLine()) != null) {
			fileWriter.write(line);
		}

		// Добавление содержимого первого файла
		for (String fileLine: fileContent) {
			fileWriter.write(fileLine);
		}

		// Закрытие потоков
		reader.close();
		fileReader1.close();
		fileReader2.close();
		fileWriter.flush();
		fileWriter.close();

	}
}
