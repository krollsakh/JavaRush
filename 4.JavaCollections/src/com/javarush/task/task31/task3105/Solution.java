package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        final int BUFFER_SIZE = 2048; //буффер для чтения из архива
        Map<String, ByteArrayOutputStream> map = new HashMap<>(); // мап для помещение байтов каждого ZipEntry из архива

        String fileName = args[0];
        String fileNameArchive = args[1];

        /*
        чтение данных архива и помещение их в Map
        */

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(fileNameArchive));
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int count;
            byte[] data = new byte[BUFFER_SIZE];
            while ((count = zipInputStream.read(data, 0, BUFFER_SIZE)) != -1) {
                outputStream.write(data, 0, count);
            }
            map.put(zipEntry.getName(), outputStream);
        }
        zipInputStream.close();

        /*
        Помещение данных в архив
        */

        // создаем архив
        FileOutputStream zipFile = new FileOutputStream(fileNameArchive);
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //кладем в него ZipEntry – «архивный объект» - первый аргумент
        Path newFile = Paths.get(fileName);
        zip.putNextEntry(new ZipEntry("/new/" + newFile.getFileName()));

        //копируем файл в архив в архив под именем первого аргумента
        File file = new File(fileName);
        Files.copy(file.toPath(), zip);

        // Добавляем данные из Map
        for (Map.Entry<String, ByteArrayOutputStream> entry : map.entrySet()) {
            zip.putNextEntry(new ZipEntry(entry.getKey()));
            entry.getValue().writeTo(zip);
        }

        // закрываем архив
        zip.close();
    }
}
