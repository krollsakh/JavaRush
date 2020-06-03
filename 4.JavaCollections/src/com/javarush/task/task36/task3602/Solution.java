package com.javarush.task.task36.task3602;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        for (Class<?> clazz: classes) {
            if (List.class.isAssignableFrom(clazz)) {
                int modifiers = clazz.getModifiers();
                if (Modifier.isPrivate(modifiers)) {
                    if (Modifier.isStatic(modifiers)) {
                        try {
                            if (clazz.getDeclaredConstructor().getParameterCount() == 0) {
                                return clazz;
                            };
                        } catch (NoSuchMethodException e) {
                        }
                    }
                }
            }
        }
        return null;
    }
}
