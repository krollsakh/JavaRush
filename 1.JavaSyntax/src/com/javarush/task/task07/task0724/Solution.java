package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
	public static void main(String[] args) {
	    Human grandFather1 = new Human("aksjdh asd", true, 75);
	    Human grandMother1 = new Human("aksjdhas as", false, 76);
	    Human grandFather2 = new Human("aksjdh asdas", true, 77);
	    Human grandMother2 = new Human("aksjdh asd", false, 78);

	    Human father1 = new Human("c`zcx`xzc", true, 40, grandFather1, grandMother1);
	    Human mother1 = new Human("asdjkfhg asdjfgh", false, 39, grandFather2, grandMother2);
	    Human son1 = new Human("askjhs asjdh", true, 14, father1, mother1);
	    Human son2 = new Human("askhg aSKJDG", true, 11, father1, mother1);
	    Human dauther = new Human("oeiuncss hsk", false, 13, father1, mother1);

		System.out.println(grandFather1.toString());
		System.out.println(grandFather2.toString());
		System.out.println(grandMother1.toString());
		System.out.println(grandMother2.toString());
		System.out.println(father1.toString());
		System.out.println(mother1.toString());
		System.out.println(son1.toString());
		System.out.println(son2.toString());
		System.out.println(dauther.toString());

	}

	public static class Human {
		private String name;
		private boolean sex;
        private int age;
        private Human father;
        private Human mother;


		public String toString() {
			String text = "";
			text += "Имя: " + this.name;
			text += ", пол: " + (this.sex ? "мужской" : "женский");
			text += ", возраст: " + this.age;

			if (this.father != null) {
				text += ", отец: " + this.father.name;
			}

			if (this.mother != null) {
				text += ", мать: " + this.mother.name;
			}

			return text;
		}

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
    }
}