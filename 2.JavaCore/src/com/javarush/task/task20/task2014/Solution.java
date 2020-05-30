package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        File file = File.createTempFile("prefix", ".txt");
        System.out.println(file);
        OutputStream outputStream = new FileOutputStream(file);

        Solution savedObject = new Solution(36);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(savedObject);
        oos.close();

        InputStream inputStream = new FileInputStream(file);
        Solution loadedObject = new Solution(39);
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        loadedObject = (Solution) ois.readObject();
        ois.close();

        System.out.println("savedObject.string = " + savedObject.string);
        System.out.println("loadedObject.string = " + loadedObject.string);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
