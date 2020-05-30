package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zergus = new Zerg();
        zergus.name = "Zergus";
        Zerg zergas = new Zerg();
        zergas.name = "Zergas";
        Zerg zergis = new Zerg();
        zergis.name = "Zergis";
        Zerg zergos = new Zerg();
        zergos.name = "Zergos";
        Zerg zerges = new Zerg();
        zerges.name = "Zerges";

        Protoss proteus = new Protoss();
        proteus.name = "Proteus";
        Protoss proprorius = new Protoss();
        proprorius.name = "Proprorius";
        Protoss prosius = new Protoss();
        prosius.name = "Prosius";

        Terran terranus = new Terran();
        terranus.name = "Terranus";
        Terran ternus = new Terran();
        ternus.name = "Ternus";
        Terran terbus = new Terran();
        terbus.name = "Terbus";
        Terran terzis = new Terran();
        terzis.name = "Terzis";

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
