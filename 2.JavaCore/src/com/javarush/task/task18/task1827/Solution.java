package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {

		if (args.length > 0) {
			if (args[0].equals("-c")) {

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String fileName = reader.readLine();

				BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "windows-1251"));

				// Получаем новый идентификатор
				String line;
				int num;
				int id = 0;
				while ((line = fileReader.readLine()) != null) {
					num = Integer.parseInt(line.substring(0, 8).trim());
					id = (id < num) ? num : id;
				}
				id++;

				// Полчаем остальные реквизиты
				String name = args[1];
				String price = args[2];
				String quantity = args[3];

				// запись в файл
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "windows-1251"));
				writer.newLine(); //можно и без этой строки, добавив %n в формат, но, говорят, валидатор не принимает
				writer.write(String.format("%8d%-30.30s%-8.8s%-4.8s", id, name, price, quantity));

				// Закрытие потоков
				writer.flush();
				writer.close();
				fileReader.close();
			}

		}
	}
}
