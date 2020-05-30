package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = fileReader.readLine()) != null) {
            int count = 0;
            for (String word : words) {
                Pattern pattern = Pattern.compile("(?<=|\\s)" + word + "(?=\\s+|$|\\p{P})");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
            }

            if (count == 2) {
                System.out.println(line);
            }
        }

        fileReader.close();

    }
}

/*
    final String regex =
    final String string = "word file word";

    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
        System.out.println("Full match: " + matcher.group(0));
        for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
        }
        }
        Please keep in mind that these co

 */