package com.company;

public class Rope implements Usable, Pickable {
    /**
     * Lekéri a paraméterül kapott karakter mezőjét,
     *  majd annak a "d" irányban lévő szomszédját.
     * A szomszédon meghívja a removeCharacters(i: Icetable) függvényt,
     *  ahol i az a mező, amin a karakter áll.
     * @param c a karakter, aki meghívja a függvényt
     * @param d a tárgy használatánk iránya
     */
    @Override
    public void use(Character c, Direction d) {
        System.out.println(Main.tab + ">Rope.use(Character, Direction)");
        Main.tab += "\t";

        IceTable i = c.getIceTable();
        IceTable left = i.getNeighbour(d);
        left.removeCharacters(i);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<Rope.use(Character, Direction)");
    }

    /**
     * A paraméterül kapott karakternek meghívja az addUsable(u: Usable) függvényét,
     *  amiben paraméterül saját magát adja.
     * @param c a karakter, aki el felveszi.
     */
    @Override
    public void pickUp(Character c) {
        System.out.println(Main.tab + ">Rope.pickUp(Character)");
        Main.tab += "\t";

        c.addUsable(this);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<Rope.pickUp(Character)");
    }
}
