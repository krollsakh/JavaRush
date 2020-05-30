package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private int age;
        private int hight;
        private int weight;
        private boolean sex;

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(boolean sex) {
            this.sex = sex;
            this.firstName = "Unknown";
            this.lastName = "Unknown";
        }

        public Human(String firstName, String lastName, int age, int hight, int weight, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hight = hight;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, int hight, int weight) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.hight = hight;
            this.weight = weight;
        }

        public Human(int age, int hight, int weight, boolean sex) {
            this.age = age;
            this.hight = hight;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(int hight, int weight, boolean sex) {
            this.hight = hight;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(int hight, int weight) {
            this.hight = hight;
            this.weight = weight;
        }

        public Human(String lastName) {
            this.lastName = lastName;
        }
    }
}
