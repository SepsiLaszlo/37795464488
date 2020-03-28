package com.company;

/**
 * A sarkkutatót reprezentáló osztály.
 * Különleges képessége, hogy meg tudja nézni, hogy mennyi a táblák kapacitása.
 */
public class Researcher extends Character {
    /**
     * A Researcher osztály konstruktora. Meghívja a Character ősosztály konstruktorát.
     * @param i Erre a jégtáblára lépteti a szereplőt.
     */
    public Researcher(IceTable i) {
        super(i);
        bodyTemperature = 4;
    }

    /**
     * A sarkkutató speciális képességéhez tartozó függvény.
     * Ha a paraméterben kapott jégtábla szomszédos,
     * akkor lekérdezi annak kapacitását és visszaadja.
     * @param t A jégtábla.
     * @return A jégtábla kapacitása.
     */
    @Override
    public int useAbility(IceTable t) {
        System.out.println(Main.tab + ">Researcher.useAbility(IceTable)");
        Main.tab += "\t";

        int c = t.getCapacity();

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + c + "<Researcher.useAbility(IceTable)");
        return c;
    }
}
