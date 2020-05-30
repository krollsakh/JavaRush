package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                Date db = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]);
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], db));
                } else {
                    allPeople.add(Person.createFemale(args[1], db));
                }
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                Date db2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]);
                Person uPerson;
                if (args[3].equals("м")) {
                    uPerson = Person.createMale(args[2], db2);
                } else {
                    uPerson = Person.createFemale(args[2], db2);
                }
                allPeople.set(Integer.parseInt(args[1]), uPerson);
                break;
            case "-d":
                Person nullPerson = allPeople.get(Integer.parseInt(args[1]));
                nullPerson.setName(null);
                nullPerson.setBirthDate(null);
                nullPerson.setSex(null);
                allPeople.set(Integer.parseInt(args[1]), nullPerson);
                break;
            case "-i":
                Person ourPeople = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(ourPeople.getName() + " " + ((ourPeople.getSex() == Sex.MALE) ? "м" : "ж") + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)).format(ourPeople.getBirthDate()));
                break;
            default:
                System.out.println(args[0]);
        }
    }
}
