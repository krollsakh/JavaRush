package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    //откуда, куда, временная, количество
    public static void moveRing(char a, char b, char c, int numRings) {
        if (numRings == 0) {
            return;
        }
        moveRing(a, c, b, numRings - 1 );  //перенести с откуда на временную n-1
        System.out.println("from " + a + " to " + b);//перенести с откуда на куда 1
        moveRing(c, b, a, numRings - 1 );  //перенести с временной на куда n-1
    }
}