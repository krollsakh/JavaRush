package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        String line;
        boolean needComma = false;
        while ((line = fileReader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() > 6) {
                    fileWriter.write((needComma ? "," : "") + word);
                    needComma = true;
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
