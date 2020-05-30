package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/

public class Solution {
    public static void main(String[] args) {

    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Edible {
        void beEaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }

    public class Dog implements Movable, Eat {

        @Override
        public void move() {
            System.out.println("Собака бежит");
        }

        @Override
        public void eat() {
            System.out.println("Собака ест");
        }
    }

    public class Cat implements Movable, Eat, Edible{

        @Override
        public void move() {
            System.out.println("Cat moving");
        }

        @Override
        public void beEaten() {
            System.out.println("Cat was eaten");
        }

        @Override
        public void eat() {
            System.out.println("Cat eat");
        }
    }

    public class Mouse implements Movable, Edible{

        @Override
        public void move() {
            System.out.println("Mouse moving");
        }

        @Override
        public void beEaten() {
            System.out.println("Mouse was eaten");
        }
    }
}