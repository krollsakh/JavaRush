package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public static void main(String[] args) {

    }

    public void initialize(String name) {
        this.name = name;
        age = 10;
        weight = 10;
        color = "Gray";
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "Gray";
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        weight = 10;
        color = "Gray";
    }

    public void initialize(int weight, String color) {
        age = 10;
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color, String address) {
        age = 10;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

}
