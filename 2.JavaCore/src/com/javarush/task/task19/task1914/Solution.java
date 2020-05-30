package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static TestString testString = new TestString();

	public static void main(String[] args) {
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
		String resultString = outputStream.toString();
		int resultInt = 0;

		//Возвращаем все как было
		System.setOut(consoleStream);

		//вычисляем выражение
		Pattern pat = Pattern.compile("^(\\d+)\\s*([+\\-*])\\s*(\\d+)\\s*=");
		Matcher mat = pat.matcher(resultString);
		if (mat.find()) {
			int firstDigit = Integer.parseInt(mat.group(1));
			int secondDigit = Integer.parseInt(mat.group(3));;
			switch (mat.group(2)) {
				case ("+"):
					resultInt =  firstDigit + secondDigit;
					break;
				case ("-"):
					resultInt =  firstDigit - secondDigit;
					break;
				case ("/"):
					resultInt =  firstDigit / secondDigit;
					break;
				case ("*"):
					resultInt =  firstDigit * secondDigit;
					break;
			}
		}

		System.out.println(resultString.trim() + " " + resultInt);
	}

	public static class TestString {
		public void printSomething() {
			System.out.println("3 + 6 = ");
		}
	}
}

