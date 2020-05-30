package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        byte[] bytes = new byte[fileInputStream.available()];
        int count = fileInputStream.read(bytes);
        for (int i = count-1; i >= 0 ; i--) {
            fileOutputStream.write(bytes[i]);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
