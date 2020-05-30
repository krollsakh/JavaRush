package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 4");
    }


    public static int getRectangleCount(byte[][] a) {
        int side = a.length;
        int rectangleCount = 0;
        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++)
                if (a[y][x]==1 && (x + 1 == side || a[y][x+1] == 0) && (y + 1 == side || a[y+1][x] == 0)) {
                    rectangleCount++;
                }
        }
        return rectangleCount;
    }
}
