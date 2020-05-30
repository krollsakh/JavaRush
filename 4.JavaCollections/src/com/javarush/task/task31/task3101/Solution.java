package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File resultFile = new File(resultFileAbsolutePath.getParent() + "/" + "allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, resultFile);

        ArrayList<File> resultFileList = new ArrayList<>();

        // Добавляем файлы в ArrayList (рекурсивный обход)
        addFilesInMap(resultFileList, path);

        // Сортировка по имени (getName)
        resultFileList.sort(Comparator.comparing(File::getName));

        //удаляем из мапа сам результирующий файл... но нужно ли?
        //mapFiles.remove(resultFile);

        BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFile)));
        for (File file: resultFileList) {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = fileReader.readLine()) != null) {
                fileWriter.write(line + "\n");
            }
            fileReader.close();
        }
        fileWriter.close();
    }

    public static void addFilesInMap(ArrayList<File> listFiles, File file) {
        if (file.isFile()) {
            if (file.length() <= 50) {
                listFiles.add(file);
            }
        } else {
            for (File dirFile : file.listFiles()) {
                addFilesInMap(listFiles, dirFile);
            }
        }
    }

}
