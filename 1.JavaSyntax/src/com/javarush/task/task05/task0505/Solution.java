package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        Cat mart = new Cat("Mart", 7, 10, 10);
        Cat fart = new Cat("Fart", 8, 9, 11);
        Cat sart = new Cat("Sart", 9, 11, 7);

        System.out.println("Битва " + mart.name + " против " + fart.name + " окончилась победой " + (mart.fight(fart) ? mart.name : fart.name));
        System.out.println("Битва " + sart.name + " против " + fart.name + " окончилась победой " + (sart.fight(fart) ? sart.name : fart.name));
        System.out.println("Битва " + mart.name + " против " + sart.name + " окончилась победой " + (mart.fight(sart) ? mart.name : sart.name));
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
