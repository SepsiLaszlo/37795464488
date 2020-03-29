package com.company;

import java.util.ArrayList;

/**
 * A jégmezőt reprezentáló osztály. Tartalmazza a jégtáblákat.
 */
public class IceField {
    private ArrayList<IceTable> iceTables = new ArrayList<IceTable>();

    /**
     * Jégmező létrehozása, abban tárgyak elhelyezése.
     */
    public void initialize() {
        System.out.println(Main.tab + ">IceField.initialize()");
        Main.tab += "\t";
        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<IceField.initialize()");
    }

    /**
     * Hóvihar közben a hó szétosztása a táblákon.
     */
    public void snowStorm() {
        System.out.println(Main.tab + ">IceField.snowStorm()");
        Main.tab += "\t";

        for (IceTable t : iceTables) {
            t.addSnow(1);
            ArrayList<Character> characters = t.getUnprotectedCharacters();
            for (Character c : characters) {
                c.changeHeat(-1);
            }
        }

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<IceField.snowStorm()");
    }

    /**
     * Hozzáad az iceTables listához egy IceTable példányt.
     *
     * @param it A hozzáadandó IceTable.
     */
    public void addIceTable(IceTable it) {

        System.out.println(Main.tab + ">IceField.addIceTable(IceTable)");
        Main.tab += "\t";

        iceTables.add(it);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<IceField.addIceTable(IceTable)");

    }
}
