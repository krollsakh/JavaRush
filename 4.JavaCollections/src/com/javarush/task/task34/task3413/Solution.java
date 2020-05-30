package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        AnyObject anyObject = new AnyObject(1L, "Name", "Desc");

        cache.put(1L, anyObject);
        cache.put(1L, anyObject);

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
    }
}