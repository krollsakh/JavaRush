package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        Pattern patternParam = Pattern.compile("(?<=[?&])\\w+(?=[=&])");
        Matcher matcherParam = patternParam.matcher(url);

        while (matcherParam.find()) {
            System.out.print(matcherParam.group() + " ");
        }

        patternParam = Pattern.compile("(?<=(obj=))\\w+[\\\\.]?\\w+");
        matcherParam = patternParam.matcher(url);

        if (matcherParam.find()) {

            String obj = matcherParam.group();

            System.out.println();

            try {
                alert(Double.parseDouble(obj));
            } catch (NumberFormatException e) {
                alert(obj);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
