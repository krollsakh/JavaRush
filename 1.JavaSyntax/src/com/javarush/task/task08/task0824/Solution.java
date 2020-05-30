package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/*
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human human7 = new Human();
        human7.age = 15;
        human7.name = "Дитя 1";
        human7.sex = true;

        Human human8 = new Human();
        human8.age = 16;
        human8.name = "Дитя 2";
        human8.sex = true;

        Human human9 = new Human();
        human9.age = 17;
        human9.name = "Дитя 3";
        human9.sex = true;

        Human human5 = new Human();
        human5.age = 45;
        human5.name = "Отец";
        human5.sex = true;
        human5.children.add(human7);
        human5.children.add(human8);
        human5.children.add(human9);

        Human human6 = new Human();
        human6.age = 45;
        human6.name = "Мать";
        human6.sex = false;
        human6.children.add(human7);
        human6.children.add(human8);
        human6.children.add(human9);

        Human human1 = new Human();
        human1.age = 88;
        human1.name = "Дедушка 1";
        human1.sex = true;
        human1.children.add(human5);

        Human human2 = new Human();
        human2.age = 89;
        human2.name = "Дедушка 2";
        human2.sex = true;
        human2.children.add(human6);

        Human human3 = new Human();
        human3.age = 89;
        human3.name = "Бабушка 1";
        human3.sex = false;
        human3.children.add(human5);

        Human human4 = new Human();
        human4.age = 89;
        human4.name = "Бабушка 2";
        human4.sex = false;
        human4.children.add(human6);

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);
        System.out.println(human5);
        System.out.println(human6);
        System.out.println(human7);
        System.out.println(human8);
        System.out.println(human9);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
