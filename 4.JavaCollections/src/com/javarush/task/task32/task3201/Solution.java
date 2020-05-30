package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        int number = Integer.parseInt(args[1]);
        raf.seek(number);
        raf.write(args[2].getBytes());

        if (raf.length() < number) {
            raf.seek(raf.length());
        } else {
            raf.seek(number);
        }

        raf.close();
    }
}
