package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        List<String> result = new ArrayList<>();
        Queue<File> dirs = new LinkedList<>();

        File fileRoot = new File(root);

        // вместо цикла for each можно использовать:
        //Collections.addAll(dirs, fileRoot.listFiles());

        //dirs.add(fileRoot);
        for (File file: fileRoot.listFiles()) {
            if (file.isFile()) {
                result.add(file.getAbsolutePath());
            } else {
                dirs.add(file);
            }
        }

        while (!dirs.isEmpty()) {
            File currentFile = dirs.poll();
            if (currentFile.isDirectory()) {
                for (File file: currentFile.listFiles()) {
                    dirs.add(file);
                }
            } else {
                result.add(currentFile.getAbsolutePath());
            }
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("/Users/sergey/Downloads/");
        list.forEach(System.out::println);
    }
}
