package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws Exception {
        Set<Animal> set = new HashSet<>();

        // список файлов в нашей директории
        File[] files = new File(pathToAnimals).listFiles();

        // имя пакета (не заморачиваемся с вырезанием слешей, да и диск в виндах ставят)
        String packageName = Solution.class.getPackage().getName() + ".data";

        for (File file : files) {
            Class clazz = new MyLoader().loadFromFile(packageName, file);

            // "Принадлежность" к интерфейсу
            if (Animal.class.isAssignableFrom(clazz)) {
                try {
                    clazz.getConstructor(); //если нет дефолтного конструктора без параметров - выбросит исключение
                    set.add((Animal) clazz.newInstance());
                } catch (Exception e) {
                }
            }
        }
        return set;
    }

}

class MyLoader extends ClassLoader {
    public Class<?> loadFromFile(String packageName, File file) {
        String className = packageName + "." + file.getName().replace(".class", "");

        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class<?> cl = defineClass(className, bytes, 0, bytes.length);
        return cl;
    }
}
