package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);


        switch (args[0]) {
            case "-e":
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(~fileInputStream.read());
                }
                break;
            case "-d":
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(~fileInputStream.read());
                }
                break;
            default:
                System.out.println("Invalid argument");
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

}
