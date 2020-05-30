package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
	public int age;
	public int weight;
	public int strength;

	public Cat() {
	}

	public static void main(String[] args) {

	}

	public boolean fight(Cat anotherCat) {
		//напишите тут ваш код
		int win = 0;

		// плюсуем параметры победы
        if (this.age > anotherCat.age) {
            win++;
        } else if (this.age < anotherCat.age) {
            win--;
        }
        if (this.weight > anotherCat.weight) {
            win++;
        } else if (this.weight < anotherCat.weight) {
            win--;
        }
        if (this.strength > anotherCat.strength) {
            win++;
        } else if (this.strength < anotherCat.strength) {
            win--;
        }

        return win <= 0 ? false : true;
	}
}
