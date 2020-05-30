package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        //    array[i] = "a" + i + "b";
        }

//        array[0] = "qweqwe";
//        array[1] = "adsaad";
//        array[2] = "zxc";
//        array[3] = "xvcc";
//        array[4] = "sfsdf";
//        array[5] = "wrer";
//        array[6] = "dfgfd";
//        array[6] = "xvxcv";
//        array[7] = "dgfgfd";
//        array[8] = "ety";
//        array[10] = "dfg";
//        array[11] = "fghfg";
//        array[12] = "gnhggn";
//        array[13] = "yujyuj";
//        array[14] = "xbcxvb";
//        array[15] = "iulliu";
//        array[16] = "fhdhd";
//        array[17] = "nmmb";
//        array[18] = "jgjgh";
//        array[19] = "rtyt";


        sort(array);

        for (String word : array) {
            System.out.println(word);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        String tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            //System.out.println(array[i]);
            if (isGreaterThan(array[i - 1], array[i])) {
                tmp = array[i];
                array[i] = array[i-1];
                array[i-1] = tmp;

                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (isGreaterThan(array[z - 1], array[z])) {
                        tmp = array[z];
                        array[z] = array[z-1];
                        array[z-1] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
