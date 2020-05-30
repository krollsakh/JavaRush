package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private static int countDir = 0;
    private static int countFiles = 0;
    private static long summarySize = 0;

    public static void main(String[] args) throws IOException {
        // /Users/sergey/Downloads
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strDirectory = reader.readLine();
        Path directory = Paths.get(strDirectory);
        if (Files.isDirectory(directory)) {
            EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
            final Solution solution = new Solution();

            Files.walkFileTree(directory, options, 20, solution);
            System.out.println("Всего папок - " + (countDir-1));
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + summarySize);
        } else {
            System.out.println(directory.toString() + " - не папка");
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countFiles++;
        summarySize += attrs.size();
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countDir++;
        return super.preVisitDirectory(dir, attrs);
    }
}
