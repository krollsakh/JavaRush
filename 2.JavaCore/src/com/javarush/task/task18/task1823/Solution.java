package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        // 1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            // 2. Для каждого файла создай нить ReadThread и запусти ее.
            new ReadThread(fileName).start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                // 3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
                FileInputStream fileInputStream = new FileInputStream(fileName);

                // 4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
                HashMap<Integer, Integer> byteMap = new HashMap<>();
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    byteMap.merge(data, 1, Integer::sum);
                }

                int maxValues = Collections.max(byteMap.values());
                // Нахождение первого ключа по значению
                Integer ourByte = byteMap.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().equals(maxValues))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .get();
                resultMap.put(fileName, ourByte);

                // 5. Поток для чтения из файла в каждой нити должен быть закрыт.
                fileInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
