package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        // считывание имен файлов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        // считывание файлов в листы

        BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));

        List<String> listLines1 = new ArrayList<>();
        String line;
        while ((line = fileReader1.readLine()) != null) {
            listLines1.add(line);
        }

        List<String> listLines2 = new ArrayList<>();
        while ((line = fileReader2.readLine()) != null) {
            listLines2.add(line);
        }

        // ззкрытие потоков

        fileReader1.close();
        fileReader2.close();

        // считываание

        int i1 = 0;
        int i2 = 0;
        String line_1; // строка из файла1 / списка listLines1
        String line_2; // строка из файла 2 / списка listLines2
        while (i1 < listLines1.size() && i2 < listLines2.size()) {
            line_1 = listLines1.get(i1);
            line_2 = listLines2.get(i2);
            if (line_1.equals(line_2)) {
                //SAME
                lines.add(new LineItem(Type.SAME, line_1));
                i1++;
                i2++;
            } else {
                if (listLines1.get(i1+1).equals(line_2)) {
                    //REMOVED + SAME
                    lines.add(new LineItem(Type.REMOVED, line_1));
                    i1++;
                } else {
                    //ADDED
                    i2++;
                    lines.add(new LineItem(Type.ADDED, line_2));
                }
            }
        }

        // запись остатков

        if (i1 < listLines1.size()) {
            for (int i = i1; i < listLines1.size(); i++) {
                lines.add(new LineItem(Type.REMOVED, listLines1.get(i)));
            }
        }
        if (i2 < listLines2.size()) {
            for (int i = i2; i < listLines2.size(); i++) {
                lines.add(new LineItem(Type.ADDED, listLines2.get(i)));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
