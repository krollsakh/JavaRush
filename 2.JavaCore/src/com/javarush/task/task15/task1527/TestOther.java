package com.javarush.task.task15.task1527;

/*
Парсер реквестов
*/

import java.util.*;
import java.io.*;
import java.text.*;

public class TestOther {
    public static void main(String[] args) throws IOException {
        String s;   //add your code here
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        s = red.readLine();
        int start = 0;
        int end = 0;
        String finale = "";
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 1).equals("?")) {
                start = i;
                break;
            }
        }
        for (int j = start + 1; j < s.length() - 1; j++) {
            if (s.substring(j, j + 1).equals("=")) {
                end = j;
                finale = finale + s.substring(start + 1, end);
                start = j;
                break;
            }
        }
        for (int k = start + 1; k < s.length() - 1; k++) {
            if (s.substring(k, k + 1).equals("&")) {
                start = k;
                for (int l = start + 1; l < s.length() - 1; l++) {
                    if (s.substring(l, l + 1).equals("=") || s.substring(l, l + 1).equals("&")) {
                        end = l;
                        finale = finale + " " + s.substring(start + 1, end);
                        break;
                    }
                }
            }
        }
        System.out.println(finale);
        String val = null;
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.substring(i, i + 3).equals("obj")) {
                start = i;
                for (int j = start; j < s.length() - 1; j++) {
                    if (s.substring(j, j + 1).equals("=")) {
                        start = j;
                        for (int k = start + 1; k < s.length() - 1; k++) {
                            if (s.substring(k, k + 1).equals("&")) {
                                end = k;
                                val = s.substring(start + 1, end);
                            }
                        }
                    }
                }
            }
        }
        if (isInteger(val)) {
            alert(Double.parseDouble(val));
        } else {
            alert(val);
        }
    }

    private static boolean isInteger(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
