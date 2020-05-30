package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        // от лени не проверяем, правильно ли все с параметрами, подразумевается, что параметр всегда есть и он правильный

        //1. Программа должна считать имя файла с консоли.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //2. Создай для файла поток для чтения.
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        //3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
        String line;
        while ((line = fileReader.readLine()) != null) {
            if (line.startsWith(args[0] + " ")) {
                System.out.println(line);
            }
        }

        //4. Поток для чтения из файла должен быть закрыт.
        reader.close();
        fileReader.close();
    }
}
