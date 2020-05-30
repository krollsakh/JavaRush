package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        //1. Программа должна считывать имя файла с консоли (используй BufferedReader).
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //2. BufferedReader для считывания данных с консоли должен быть закрыт.
        reader.close();

        //3. Программа должна считывать содержимое файла (используй FileReader).
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        //5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.

        // Считываем все содержимое файла, используя StringBuilder
        StringBuilder textFile = new StringBuilder();

        String line;
        while ((line = fileReader.readLine()) != null) {
            textFile.append(line);
        }

        // тэг, стек и мап
        String tag = args[0];
        Stack<Integer> intStack = new Stack<>();
        Map<Integer, String> map = new TreeMap<>();

        // поиск тэгов:
        // - находим тэг
        // - если это открывающий тэг - помещаем в стек индекс найденного
        // - если это открывающий тэг - снимаем со стека значение и пишем его ключом в мап со значением substr
        //     от индекса со стека до текущиего найденного. То есть получаем тэг с содержимым и индексом когда он начался

        Matcher matcher = Pattern.compile("</?" + tag + ".*?>").matcher(textFile);
        while (matcher.find()) {
            //находим начало тэга и помещаем индекс начала в стек
            if (matcher.group().matches("<" + tag + ".*?")) {
                intStack.push(matcher.start());
            } else if (matcher.group().matches("</" + tag + ">")) {
                int begin = intStack.pop();
                map.put(begin, textFile.substring(begin, matcher.end()));
            }
        }

        //вывод на консоль
        map.forEach((k,v) -> System.out.println(v));

        //4. Поток чтения из файла (FileReader) должен быть закрыт.
        fileReader.close();
    }
}
