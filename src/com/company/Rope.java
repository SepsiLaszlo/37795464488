package com.company;

/**
 * A kötelet reprezentáló osztály. Ennek a segítségével lehet karaktereket a vízből kimenteni.
 */
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
        IceTable i = c.getIceTable();
        IceTable left = i.getNeighbour(d);
        left.removeCharacters(i);
    }

    /**
     * A paraméterül kapott karakternek meghívja az addUsable(u: Usable) függvényét,
     *  amiben paraméterül saját magát adja.
     * @param c a karakter, aki el felveszi.
     */
    @Override
    public void pickUp(Character c) {
        c.addUsable(this);
    }

    @Override
    public String toString() {
        return "Rope";
    }
}
