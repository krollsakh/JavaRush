package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            BufferedReader reader1 = new BufferedReader(new FileReader(new File(fileName1)));
            String line1 = reader1.readLine();
            while (line1 != null) {
                allLines.add(line1);
                line1 = reader1.readLine();
            }

            BufferedReader reader2 = new BufferedReader(new FileReader(new File(fileName2)));
            String line2 = reader2.readLine();
            while (line2 != null) {
                forRemoveLines.add(line2);
                line2 = reader2.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            (new Solution()).joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
