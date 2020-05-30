package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        Date db;
        int currentArg = 0;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    while (currentArg < args.length - 1) {
                        db = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3 + currentArg]);
                        if (args[2 + currentArg].equals("м")) {
                            allPeople.add(Person.createMale(args[1 + currentArg], db));
                        } else {
                            allPeople.add(Person.createFemale(args[1 + currentArg], db));
                        }

                        System.out.println(allPeople.size() - 1);

                        currentArg += 3;
                    }
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    Person uPerson;
                    while (currentArg < args.length - 1) {
                        db = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4 + currentArg]);
                        if (args[3 + currentArg].equals("м")) {
                            uPerson = Person.createMale(args[2 + currentArg], db);
                        } else {
                            uPerson = Person.createFemale(args[2 + currentArg], db);
                        }
                        allPeople.set(Integer.parseInt(args[1 + currentArg]), uPerson);
                        currentArg += 4;
                    }
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    Person nullPerson;
                    currentArg = 1;
                    while (currentArg < args.length) {
                        nullPerson = allPeople.get(Integer.parseInt(args[currentArg]));
                        nullPerson.setName(null);
                        nullPerson.setBirthDate(null);
                        nullPerson.setSex(null);
                        allPeople.set(Integer.parseInt(args[currentArg]), nullPerson);
                        currentArg++;
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    Person ourPeople;
                    currentArg = 1;
                    while (currentArg < args.length) {
                        ourPeople = allPeople.get(Integer.parseInt(args[currentArg]));
                        System.out.println(ourPeople.getName() + " " + ((ourPeople.getSex() == Sex.MALE) ? "м" : "ж") + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)).format(ourPeople.getBirthDate()));
                        currentArg++;
                    }
                }
                break;

            default:
                System.out.println(args[0]);
        }

    }
}
