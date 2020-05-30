package My_Examples;

/*
2   Как получить список всех файлов в директории и ее поддиректориях?
3	Как получить список всех файлов в директории с расширением zip?
4	Как заархивировать файл?
5	Как заархивировать много файлов?
6	Как заархивировать много файлов и директорий?
7	Как разархивировать файл?
8	Как задать кодировку файла?
9	Как узнать кодировку файла в архиве?
10	Как поменять данные (свойства) в объекте типа Properties?
 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class FileExample {
    public static void main(String[] args) throws IOException {
        final String currentDirectory = "/Users/sergey/Downloads";


        /*
        //2.(1 из 3) Как получить список всех файлов в директории и ее поддиректориях?
        // Рекурсивный метод
        ArrayList<File> resultFileList = new ArrayList<>();
        //  --  Добавляем файлы в ArrayList (рекурсивный обход)
        addFilesInMap(resultFileList, new File("/Users/sergey/Downloads"));
        //  --  Сортировка по имени (getName)
        //resultFileList.sort(Comparator.comparing(File::getAbsoluteFile));
        //  --  Вывод на консоль
        resultFileList.forEach(System.out::println);
        */

        //2.(2 из 3) Как получить список всех файлов в директории и ее поддиректориях?
        //расширенный обход при помощи Files.walkFileTree()
        // https://javarush.ru/groups/posts/2275-files-path

        //2.(3 из 3) Как получить список всех файлов в директории и ее поддиректориях?
        // Stream API
        /*
        Files.walk(Paths.get("/Users/sergey/Downloads"))
                .sorted()
                .forEach(System.out::println);
         */

        //3	Как получить список всех файлов в директории с расширением zip?
        getZipFiles(currentDirectory);


    }

    //2.(1 из 2) Как получить список всех файлов в директории и ее поддиректориях?
    public static void addFilesInMap(ArrayList<File> listFiles, File file) {
        if (file.isFile()) {
            listFiles.add(file);
        } else {
            for (File dirFile : file.listFiles()) {
                addFilesInMap(listFiles, dirFile);
            }
        }
    }

    //3	Как получить список всех файлов в директории с расширением zip?
    public static void getZipFiles(String directory) {
        File file = new File(directory);
        String[] zipFiles = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".rar");
            }
        });

        for (String zipFile: zipFiles) {
            System.out.println(zipFile);
        }

    }

}
