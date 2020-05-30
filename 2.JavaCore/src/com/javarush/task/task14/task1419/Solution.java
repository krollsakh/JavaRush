package com.javarush.task.task14.task1419;

/*
Нашествие исключений
*/

import java.beans.ExceptionListener;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new RuntimeException());
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new NullPointerException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new InterruptedException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new IllegalArgumentException());

    }
}
