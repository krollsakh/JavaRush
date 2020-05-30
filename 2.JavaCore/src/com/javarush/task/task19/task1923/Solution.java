package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        String line;
//        Pattern pattern = Pattern.compile("\\d+");
        Pattern pattern = Pattern.compile(".*\\d+.");
        while ((line = fileReader.readLine()) != null) {
            String[] lines = line.split(" ");
            for (String word: lines) {
                Matcher matcher = pattern.matcher(word);
                while (matcher.find()) {
                    fileWriter.write(word + " ");
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
