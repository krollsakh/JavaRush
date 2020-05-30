package com.javarush.task.task19.task1907;

/*
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String line;
        int count = 0;

        while ((line = fileReader.readLine()) != null) {
            count += (" " + line + " ").split("\\b[Ww]orld\\b").length-1;
        }

        fileReader.close();

        System.out.println(count);

    }
}
