package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> files = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("end")) {
            files.add(fileName);
        }
        reader.close();
        Collections.sort(files);

        String fileFinal = files.get(0).split(".part")[0];
        BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(fileFinal));

        for (String file: files) {
            BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fileReader.available()];
            fileReader.read(buffer);
            fileWriter.write(buffer);

            fileReader.close();
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
