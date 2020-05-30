package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		// Чтение имен файлов
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName1 = reader.readLine();
		String fileName2 = reader.readLine();
		String fileName3 = reader.readLine();

		// Создание потоков
		BufferedWriter fileWriter1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName1), "windows-1251"));
		BufferedReader fileReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2), "windows-1251"));
		BufferedReader fileReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName3), "windows-1251"));

		// Запись содержимого 2-го файла в 1-й файл
		String line;
		while ((line = fileReader2.readLine()) != null) {
			fileWriter1.write(line);
		}

		// Добавление содержимого 3-го файла в 1-й файл
		while ((line = fileReader3.readLine()) != null) {
			fileWriter1.write(line);
		}

		// Закрытие потоков
		fileWriter1.flush();
		fileWriter1.close();
		fileReader2.close();
		fileReader3.close();

	}
}
