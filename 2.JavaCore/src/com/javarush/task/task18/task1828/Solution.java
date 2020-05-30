package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {

            //Считываие имени файла с консоли и открытие потока чтения из файла
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

            //Считывание данных из потока
            ArrayList<String> content = new ArrayList<>();
            String line;
            while ((line = fileReader.readLine()) != null) {
                if (args[0].equals("-u")) { //Изменение стркои
                    if (line.length() > 0 && line.substring(0, 8).trim().equals(args[1])) {
                        // Изменение данных строки
                        content.add(String.format("%-8.8s%-30.30s%-8.8s%-4.8s", args[1], args[2], args[3], args[4]));
                    } else {
                        content.add(line);
                    }
                } else if (args[0].equals("-d")) { // Удаление строки
                    if (line.length() > 0 && line.substring(0, 8).trim().equals(args[1])) {
                    } else {
                        content.add(line);
                    }
                } else {
                    //invalid argument
                }
            }

            // Закрытие потоков чтения
            reader.close();
            fileReader.close();

            // Открытие потока на запись и запись в него content
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
            fileWriter.write(content.get(0));
            for (int i = 1; i < content.size(); i++) {
                fileWriter.newLine();
                fileWriter.write(content.get(i));
            }

            // Закрытие потоков записи
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
