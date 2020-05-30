package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        boolean isTrue = true;
        while (isTrue)//тут цикл по чтению ключей, пункт 1
        {
            //создаем объект, пункт 2
            String inputString = reader.readLine();
            switch (inputString) {
                case ("user"):
                    doWork(new Person.User());
                    break;
                case ("loser"):
                    doWork(new Person.Loser());
                    break;
                case ("coder"):
                    doWork(new Person.Coder());
                    break;
                case ("proger"):
                    doWork(new Person.Proger());
                    break;
                default:
                    isTrue = false;
            }

            //doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
