package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		String lastString;
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			list.add(reader.readLine());
		}

		for (int i = 0; i < 13; i++) {
			lastString = list.get(4);
			list.add(0, list.get(4));
			list.remove(5);
		}

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
	}

}
