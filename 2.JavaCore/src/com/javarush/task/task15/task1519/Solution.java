package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String inputString = reader.readLine();
			if (inputString.equals("exit")) {
				break;
			}

			if (inputString.contains(".")) {
				try {
					print(Double.parseDouble(inputString));
				} catch (NumberFormatException e) {
					print(inputString);
				}
			} else {
				try {
					int intValue = Integer.valueOf(inputString);
					if (intValue > 0 && intValue < 128) {
						print((short) intValue);
					} else if (intValue <= 0 || intValue >= 128) {
						print(intValue);
					}
				} catch (NumberFormatException e) {
					print(inputString);
				}

			}
		}
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
