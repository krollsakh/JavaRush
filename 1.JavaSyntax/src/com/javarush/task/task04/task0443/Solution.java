package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //System.out.print("Имя: ");
        String name = reader.readLine();
        //System.out.print("Y: ");
        int y = Integer.valueOf(reader.readLine());
        //System.out.print("M: ");
        int m = Integer.valueOf(reader.readLine());
        //System.out.print("D: ");
        int d = Integer.valueOf(reader.readLine());

        System.out.println("Меня зовут " + name + ".");
        System.out.println("Я родился " + d + "." + m + "." + y);
    }
}
