package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                map.put(name, id);
                if (name.isEmpty()) {
                    break;
                }
            } catch (NumberFormatException e) {
                break;
            } catch (IOException e) {
                break;
            }

        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
