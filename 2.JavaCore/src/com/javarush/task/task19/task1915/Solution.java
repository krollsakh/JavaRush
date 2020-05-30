package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
	public static TestString testString = new TestString();

	public static void main(String[] args) throws IOException {
		//запоминаем настоящий PrintStream в специальную переменную
		PrintStream consoleStream = System.out;

		//Создаем динамический массив
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		//создаем адаптер к классу PrintStream
		PrintStream stream = new PrintStream(outputStream);
		//Устанавливаем его как текущий System.out
		System.setOut(stream);

		//Вызываем функцию, которая ничего не знает о наших манипуляциях
		testString.printSomething();

		//Преобразовываем записанные в наш ByteArray данные в строку
		String result = outputStream.toString();

		// Считываем имя файла и закрываем поток чтения
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = bufferedReader.readLine();
		bufferedReader.close();

		//Открываем поток на запись файла и пишем в файл
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		fileOutputStream.write(outputStream.toByteArray());
		fileOutputStream.flush();
		fileOutputStream.close();

		//Возвращаем все как было
		System.setOut(consoleStream);

		//Меняем все на заглавное и выводим ее в консоль
		System.out.println(result);
	}

	public static class TestString {
		public void printSomething() {
			System.out.println("it's a text for testing");
		}
	}
}
