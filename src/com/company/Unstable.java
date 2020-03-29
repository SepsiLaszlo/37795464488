package com.company;


import java.util.Scanner;

/**
 *  Az instabil jégtáblák reprezentálására. Ezekbe Pickable-ek lehetnek befagyva, állhat rajta
 * szereplő és boríthatja hó.
 */
public class Unstable extends IceTable {

    /**
     * Unstable osztály konstruktora
     *
     * @param p a táblán található tárgy (lehet null)
     */
    public Unstable(Pickable p) {
        super(p);
    }

    /**
     * Paraméterül kap egy karaktert, amit eltárol a characters listában.
     *
     * @param c eltárolandó karakter
     */
    @Override
    public void stepOn(Character c) {
        System.out.println("A jégtáblán lévő karakterek száma eléri ezzel már a tábla kapacitását?\n" +
                "Válasz: Y (Igen), N (Nem).");
        Scanner in = new Scanner(System.in);
        char answer = in.next().charAt(0);
        while (answer != 'N' && answer != 'Y') {
            System.out.println("Hibás válasz!\n" +
                    "A jégtáblán lévő karakterek száma eléri ezzel már a tábla kapacitását?\n" +
                    "Válasz: Y (Igen), N (Nem).");
            answer = in.next().charAt(0);
        }
        System.out.println(Main.tab + ">Unstable.stepOn(Character)");

        switch (answer) {
            case 'Y':
                Main.tab += "\t";
                c.die();
                Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
                System.out.println(Main.tab + "<Unstable.stepOn(Character)");
                break;
            case 'N':
                System.out.println(Main.tab + "<Unstable.stepOn(Character)");
                break;
            default:
                break;
        }
    }

    /**
     * Instabil esetben nem csinál semmit a metódus.
     *
     * @param t jégtábla, amire kimentett karaktereket helyezi
     */
    @Override
    public void removeCharacters(IceTable t) {
    }


}