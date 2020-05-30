package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String text = args[2];
        int len = text.getBytes().length;
        byte[] b = new byte[len];
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");

        raf.seek(Integer.parseInt(args[1]));
        raf.read(b, 0, len);
        String str = new String(b);

        raf.seek(raf.length());
        if (text.equals(str)) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }

    }
}
