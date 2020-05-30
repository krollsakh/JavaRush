package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Serg", 33, "NY");
        Man man2 = new Man("Adam", 33, "Edem");
        System.out.println(man1);
        System.out.println(man2);

        Woman woman1 = new Woman("July", 25, "NY");
        System.out.println(woman1);
        Woman woman2 = new Woman("Eva", 30, "Edem");
        System.out.println(woman2);
    }

    public static class Man {
        private String name;
        private int age;
        private String address;

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Man(String name, int age) {
            this(name, age, "Edem");
        }

        public Man(String name) {
            this(name, 33, "Edem");
        }

        public Man() {
            this("Adam", 33, "Edem");
        }

    }
    public static class Woman {
        private String name;
        private int age;
        private String address;

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Woman(String name, int age) {
            this(name, age, "Edem");
        }

        public Woman(String name) {
            this(name, 33, "Edem");
        }

        public Woman() {
            this("Eva", 30, "Edem");
        }

    }

}
