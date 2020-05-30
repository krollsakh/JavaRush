package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            if (fileScanner.hasNextLine()) {
                String[] lines = fileScanner.nextLine().split(" ");
                SimpleDateFormat sf = new SimpleDateFormat("ddMMyyyy");

                Date birthDate;
                try {
                    birthDate = sf.parse(lines[3] + lines[4] + lines[5]);
                } catch (ParseException e) {
                    return null;
                }

                return new Person(lines[1], lines[2], lines[0], birthDate);
            }

            return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
