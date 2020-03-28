package com.company;

/**
 * Az élelmet reprezentáló osztály. Amint felveszi a szereplő, megeszi és a testhője nő eggyel.
 */
public class Food implements Pickable {
    /**
     * A paraméterben kapott karakteren meghívja a changeHeat(int: i) függvényt (i=1), ezzel a játékosnak növeli a testhőjét.
     * @param c - A karakter, aki felveszi a tárgyat.
     */
    public void pickUp(Character c) {
        System.out.println(Main.tab + ">Food.pickUp(Character)");
        Main.tab += "\t";

        c.changeHeat(1);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<Food.pickUp(Character)");
    }
}
