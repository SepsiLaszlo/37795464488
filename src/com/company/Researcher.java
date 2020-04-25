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
        workUnit = 4;
        initialWorkUnit = 4;
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
        workUnit--;
        if (workUnit == 0) {
            game.nextPlayer();
            workUnit = initialWorkUnit;
        }
        return t.getCapacity();
    }

    /**
     * Ez a függvény üresen kerül definiálásra az sarkkutató
     * részéről.
     */
    @Override
    public void invadeOtherCharacters() { }
}
