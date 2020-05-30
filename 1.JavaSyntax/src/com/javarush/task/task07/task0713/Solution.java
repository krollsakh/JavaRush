package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> integers1 = new ArrayList<Integer>();
        ArrayList<Integer> integers2 = new ArrayList<Integer>();
        ArrayList<Integer> integers3 = new ArrayList<Integer>();
        ArrayList<Integer> integers4 = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            integers1.add(Integer.parseInt(reader.readLine()));
        }

        for (Integer x: integers1) {
            if (x % 3 == 0) {
                integers2.add(x);
                if (x % 2 == 0) {
                    integers3.add(x);
                }
            } else if (x % 2 == 0) {
                integers3.add(x);
            } else {
                integers4.add(x);
            }
        }

        printList(integers2);
        printList(integers3);
        printList(integers4);
    }

    public static void printList(ArrayList<Integer> list) {
        for (Integer x : list) {
            System.out.println(x);
        }
    }
}
