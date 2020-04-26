/**
 * Az élelmet reprezentáló osztály. Amint felveszi a szereplő, megeszi és a testhője nő eggyel.
 */
public class Food implements Pickable {
    /**
     * A paraméterben kapott karakteren meghívja a changeHeat(int: i) függvényt (i=1), ezzel a játékosnak növeli a testhőjét.
     * @param c - A karakter, aki felveszi a tárgyat.
     */
    public void pickUp(Character c) {
        c.changeHeat(1);
    }

    /**
     * Visszaadja az osztály típusát string formátumban.
     * @return az osztály típusa
     */
    public String toString() {
        return "Food";
    }
}
