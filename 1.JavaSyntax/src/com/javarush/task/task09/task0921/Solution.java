package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        int num;

        while (true) {
            try {
                num = Integer.parseInt(reader.readLine());
                arr.add(num);
            } catch (NumberFormatException | IOException e) {
                for (Integer nums : arr) {
                    System.out.println(nums);
                }
                break;
            }
        }
    }
}
