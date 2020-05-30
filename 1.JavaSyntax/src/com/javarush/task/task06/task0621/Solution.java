package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String motherName = reader.readLine();
//        Cat catMother = new Cat(motherName);
//
//        String daughterName = reader.readLine();
//        Cat catDaughter = new Cat(daughterName, catMother);
//
//        System.out.println(catMother);
//        System.out.println(catDaughter);

        //дедушка Вася
        Cat grandFather = new Cat(reader.readLine());

        //бабушка Мурка
        Cat grandMother = new Cat(reader.readLine());

        //папа Котофей
        Cat catFather = new Cat(reader.readLine(), grandFather, false);

        //мама Василиса
        Cat catMother = new Cat(reader.readLine(), grandMother, true);

        //сын Мурчик
        Cat catSon = new Cat(reader.readLine(), catMother, catFather);

        //сын Мурчик
        Cat catDother = new Cat(reader.readLine(), catMother, catFather);

        System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDother);

    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        public Cat(String name, Cat parent, boolean isMother) {
            this.name = name;
            if (isMother) {
                this.mother = parent;
            } else {
                this.father = parent;
            }
        }

        @Override
        public String toString() {
            return "The cat's name is " + name + ", " +
                    (mother == null ? "no mother" : "mother is " + mother.name) + ", " +
                    (father == null ? "no father" : "father is " + father.name);
        }
    }

}
