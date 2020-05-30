package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<>();
        map.put("Васька1", new Cat("Васька1"));
        map.put("Барсик2", new Cat("Барсик2"));
        map.put("Васька3", new Cat("Васька3"));
        map.put("Барсик4", new Cat("Барсик4"));
        map.put("Васька5", new Cat("Васька5"));
        map.put("Барсик6", new Cat("Барсик6"));
        map.put("Мурзик7", new Cat("Барсик7"));
        map.put("Мурзик8", new Cat("Барсик8"));
        map.put("Мурзик9", new Cat("Барсик9"));
        map.put("Мурзик0", new Cat("Барсик0"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<>(map.values());
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
