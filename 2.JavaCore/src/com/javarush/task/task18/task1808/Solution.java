package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);


        int all = inputStream.available();
        if (all > 1) {
            int count = all - all/2;
            byte[] buffer = new byte[all];
            inputStream.read(buffer);
            fileOutputStream1.write(buffer, 0, count);
            fileOutputStream2.write(buffer, count, all/2);
        }

        fileOutputStream1.close();
        fileOutputStream2.close();
        inputStream.close();
        reader.close();
    }
}
