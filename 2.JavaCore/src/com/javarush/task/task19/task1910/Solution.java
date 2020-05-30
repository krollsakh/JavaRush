package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

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

        //чтение и запись
        while ((line = fileReader.readLine()) != null) {
            fileWriter.write(line.replaceAll("\\p{Punct}", ""));
        }

        //закрытие потоков
        fileWriter.flush();
        fileWriter.close();
        fileReader.close();
    }
}
