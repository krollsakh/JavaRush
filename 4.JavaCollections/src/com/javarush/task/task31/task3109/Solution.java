package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;
import java.util.prefs.Preferences;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("XML");
        Properties properties = solution.getProperties("/Users/sergey/Desktop/JAVA/InteliJ Idea Workplace/JavaRushTasks/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        System.out.println("TXT");
        properties = solution.getProperties("/Users/sergey/Desktop/JAVA/InteliJ Idea Workplace/JavaRushTasks/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties");
        properties.list(System.out);

        System.out.println("NOT EXISTS");
        properties = solution.getProperties("/Users/sergey/Desktop/JAVA/InteliJ Idea Workplace/JavaRushTasks/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        FileInputStream reader;
        Properties properties = new Properties();
        try {
            reader = new FileInputStream(fileName);
            if (fileName.endsWith(".xml")) {
                properties.loadFromXML(reader);
            } else {
                properties.load(reader);
            }
        } catch (IOException e) {
            return new Properties();
        }
        return properties;
    }
}
