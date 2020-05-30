package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int fileSize = fileInputStream.available();

        while (fileSize >= 1000) {
            fileName = reader.readLine();
            fileInputStream = new FileInputStream(fileName);
            fileSize = fileInputStream.available();
        }

        fileInputStream.close();
        reader.close();
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
