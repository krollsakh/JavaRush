package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {

	private static int digit;

	public static void main(String[] args) {
		System.out.println(sumDigitsInNumber(546));
	}

	public static int sumDigitsInNumber(int number) {
		//берем первую цифру
		digit = number / 100;
        // вторая цифра
        int secondNumber = number % 100 / 10;
        // третья цифра
		int thirdNumber = number % 10;
		//
        return digit + secondNumber + thirdNumber;
	}
}