package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public static void main(String[] args) {

    }

    public Cat(String name) {
        this.name = name;
        this.age = 5;
        this.weight = 5;
        this.color = "Gray";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "Gray";
    }

    public Cat(String name, int age) {
        this.name = name;

        this.age = age;
        this.weight = 5;
        this.color = "Gray";
    }

    public Cat(int weight, String color) {
        this.age = 5;
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.address = address;
        this.color = color;
        this.age = 5;
    }
}
