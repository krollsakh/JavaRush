package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		int num = 0;
		if (args.length > 0) {
			FileInputStream fileInputStream = new FileInputStream(args[0]);
			while (fileInputStream.available() > 0) {
				int data = fileInputStream.read();
				if ((data >= 'A' && data <= 'Z') || (data >= 'a' && data <= 'z')) num++;
			}
			System.out.println(num);
			fileInputStream.close();
		}
	}
}
