package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
/*
Самые-самые
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		//напишите тут ваш код
		ArrayList<String> list = new ArrayList<String>();
		String min = null;
		String max = null;
		for (int i = 0; i < 10; i ++) {
			list.add(new BufferedReader(new InputStreamReader(System.in)).readLine());
			min = list.get(i);
			max = list.get(i);
		}

		for (int j = 0; j < list.size(); j ++) {
			if (min.length() > (list.get(j).length())) {
				min = list.get(j);
			} else if (max.length() < (list.get(j).length())) {
				max = list.get(j);
			}
		}

		for (int ij = 0; ij < list.size(); ij++) {
			if ( min.equals(list.get(ij))) {
				System.out.println(min);
				break;
			} else if (max.equals(list.get(ij))) {
				System.out.println(max);
				break;
			}
		}
	}
}