package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        //чтение имен файлов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        //объявление переменных
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        String line;
        boolean needSpace = false;

        //паттерн для слов, состоящих только из цифр
        Pattern pat = Pattern.compile("\\b\\d+\\b");

        //чтение и запись
        while ((line = fileReader.readLine()) != null) {
            Matcher mat = pat.matcher(line);
            while (mat.find()) {
                //добавляем пробел только если он нужен
                if (needSpace) {
                    fileWriter.write(" ");
                }
                needSpace = true;
                //запись числа
                fileWriter.write(mat.group());
            }
        }

        //закрытие потоков
        fileWriter.flush();
        fileWriter.close();
        fileReader.close();
    }
}
