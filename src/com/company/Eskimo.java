package com.company;

/**
 * Az eszkimó típusú karaktert reprezentáló osztály.
 * Különleges képessége, hogy tud iglut építeni.
 */
public class Eskimo extends Character {
    /**
     * Az eszkimó osztály konstruktora. Meghívja a Character ősosztály konstruktorát.
     * @param g A játék osztály
     * @param i Erre a jégtáblára lépteti a szereplőt.
     */
    public Eskimo(Game g, IceTable i) { super(g, i); }

    /**
     * A paraméterben kapott táblára épít egy iglut.
     * @param t A jégtábla.
     * @return 0, nem használandó.
     */
    @Override
    public int useAbility(IceTable t) {
        System.out.println(Main.tab + ">Eskimo.useAbility(IceTable)");
        Main.tab += "\t";

        t.addIglu();

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Eskimo.useAbility(IceTable)");
        return 0;
    }
}
